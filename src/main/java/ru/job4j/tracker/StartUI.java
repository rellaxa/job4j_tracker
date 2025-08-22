package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.store.HbmTracker;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class StartUI {

	private final Output out;

	public StartUI(Output output) {
		this.out = output;
	}

	public void init(Input input, Store memTracker, List<UserAction> actions) {
		boolean run = true;
		while (run) {
			showMenu(actions);
			int select = input.askInt("Выбрать: ");
			if (select < 0 || select >= actions.size()) {
				out.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
				continue;
			}
			UserAction action = actions.get(select);
			run = action.execute(input, memTracker);
		}
	}

	private void showMenu(List<UserAction> actions) {
		out.println("Меню:");
		for (int index = 0; index < actions.size(); index++) {
			out.println(index + ". " + actions.get(index).name());
		}
	}

	private static String loadSysEnvIfNullThenConfig(String sysEnv, String key, Properties config) {
		String value = System.getenv(sysEnv);
		if (value == null) {
			value = config.getProperty(key);
		}
		return value;
	}

	private static Connection loadConnection() throws ClassNotFoundException, SQLException {
		var config = new Properties();
		try (InputStream in = StartUI.class.getClassLoader()
				.getResourceAsStream("app.properties")) {
			config.load(in);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		String url = loadSysEnvIfNullThenConfig("JDBC_URL", "url", config);
		String username = loadSysEnvIfNullThenConfig("JDBC_USERNAME", "username", config);
		String password = loadSysEnvIfNullThenConfig("JDBC_PASSWORD", "password", config);
		String driver = loadSysEnvIfNullThenConfig("JDBC_DRIVER", "driver-class-name", config);
		System.out.println("url=" + url);
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	public static void main(String[] args) {
		Output output = new ConsoleOutput();
		Input input = new ValidateInput(output,
				new ConsoleInput());
		try (Connection connection = loadConnection()) {
			Store tracker = new SqlTracker(connection);
			List<UserAction> actions = Arrays.asList(
					new Create(output),
					new CreateManyItems(output),
					new FindAll(output),
					new Replace(output),
					new Delete(output),
					new DeleteAllItems(output),
					new FindById(output),
					new FindByName(output),
					new Exit(output)
			);
			new StartUI(output).init(input, tracker, actions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}