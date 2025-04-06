package ru.job4j.tracker.store;

import org.junit.jupiter.api.*;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @BeforeEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item replaceItem = new Item("replaceItem");
        tracker.add(item);
        tracker.replace(item.getId(), replaceItem);
        assertThat(tracker.findById(item.getId())).isEqualTo(replaceItem);
    }

    @Test
    public void whenSaveItemAndDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isEqualTo(null);
    }

    @Test
    public void whenSave2ItemsAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("item"));
        Item second = tracker.add(new Item("newItem"));
        assertThat(tracker.findByName("newItem").get(0)).isEqualTo(second);
    }

    @Test
    public void whenSave3ItemsAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));
        Item third = tracker.add(new Item("third"));
        assertThat(tracker.findAll()).isEqualTo(Arrays.asList(first, second, third));
    }
}
