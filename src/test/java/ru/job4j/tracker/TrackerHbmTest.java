package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.store.HbmTracker;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {

	private static final HbmTracker TRACKER = new HbmTracker();

	@AfterEach
	public void deleteItems() {
		TRACKER.findAll().forEach(item -> TRACKER.delete(item.getId()));
	}

	@AfterAll
	public static void cleanup() {
		TRACKER.close();
	}

	@Test
	public void whenAddNewItemThenTrackerHasSameItem() {
		var item = new Item();
		item.setName("test1");
		TRACKER.add(item);
		var result = TRACKER.findById(item.getId());
		assertThat(result.getName()).isEqualTo(item.getName());
	}

	@Test
	public void whenAdd2ItemsThenTrackerHasSameItems() {
		var one = new Item();
		one.setName("test1");
		TRACKER.add(one);
		var two = new Item();
		two.setName("test2");
		TRACKER.add(two);
		System.out.println(TRACKER.findAll());
		assertThat(TRACKER.findAll().size()).isEqualTo(2);
	}

	@Test
	public void whenReplaceExistingItemThenReturnNewItem() {
		var item = new Item();
		item.setName("item");
		TRACKER.add(item);
		var newItem = new Item();
		newItem.setName("newItem");
		int id = item.getId();
		var result = TRACKER.replace(id, newItem);
		assertThat(result).isTrue();
		assertThat(TRACKER.findById(id).getName()).isEqualTo("newItem");
	}

	@Test
	public void whenReplaceNonExistingItemThenReturnFalse() {
		var item = new Item();
		item.setName("item");
		TRACKER.add(item);
		var newItem = new Item();
		newItem.setName("newItem");
		var result = TRACKER.replace(item.getId() + 1, newItem);
		assertThat(result).isFalse();
		assertThat(TRACKER.findById(item.getId()).getName()).isEqualTo("item");
	}

	@Test
	public void whenDeleteItemThenTrackerHasNoItems() {
		var item = new Item();
		item.setName("item");
		TRACKER.add(item);
		TRACKER.delete(item.getId());
		assertThat(TRACKER.findById(item.getId())).isNull();
		assertThat(TRACKER.findAll()).isEmpty();
	}

	@Test
	public void whenFindByNameThenReturnItems() {
		var items = List.of(new Item("First"), new Item("First"), new Item("Second"), new Item("Second"));
		items.forEach(item -> TRACKER.add(item));
		var result = TRACKER.findByName("First");
		assertThat(result).hasSize(2);
		assertThat(result.get(0).getName()).isEqualTo("First");
		assertThat(result.get(1).getName()).isEqualTo("First");
	}

	@Test
	public void whenNotFindByNameThenReturnEmptyList() {
		var items = List.of(new Item("item"), new Item("item"));
		items.forEach(item -> TRACKER.add(item));
		var result = TRACKER.findByName("zero");
		assertThat(result).isEmpty();
	}

	@Test
	public void whenFindByIdThenReturnItem() {
		var item = new Item("item");
		TRACKER.add(item);
		var result = TRACKER.findById(item.getId());
		assertThat(result.getName()).isEqualTo("item");
	}

	@Test
	public void whenFindAllThenReturnItems() {
		var one = new Item("one");
		var two = new Item("two");
		var three = new Item("three");
		TRACKER.add(one);
		TRACKER.add(two);
		TRACKER.add(three);
		var result = TRACKER.findAll();
		assertThat(result).hasSize(3);
		assertThat(result).isEqualTo(List.of(one, two, three));
	}
}
