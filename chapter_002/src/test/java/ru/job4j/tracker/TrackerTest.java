package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    /**
     * Тест метода add().
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    /**
     * Тест метода add().
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        Item next = new Item("test2","testDescription2",1234L);
        tracker.add(previous);
        next.setId(previous.getId());
        tracker.replace(next.getId(),next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**
     * Тест метода delete().
     */
    @Test
    public void whenFindDeletedThenNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L);
        Item deleted = null;
        tracker.add(item1);
        String deletedId = item1.getId();
        tracker.delete(item1.getId());


        assertThat(tracker.findById(deletedId), is(deleted));
    }
    /**
     * Тест метода findAll().
     */
    @Test
    public void whenFindAllThenResultArray() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L);
        Item item2 = new Item("test1","testDescription2",1235L);
        Item item3 = new Item("test3","testDescription3",1L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expectArray = {item1,item2,item3};
        Item[] resultArray = tracker.findAll();
        assertThat(resultArray, is(expectArray));
    }
    /**
     * Тест метода findByName().
     */
    @Test
    public void whenFindByNameThenResultArray() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L);
        Item item2 = new Item("test1","testDescription2",1235L);
        Item item3 = new Item("test3","testDescription3",1L);
        Item item4 = new Item("test1","testDescription4",35L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] expectArray = {item1,item2,item4};
        Item[] resultArray = tracker.findByName("test1");
        assertThat(resultArray, is(expectArray));
    }
    /**
     * Тест метода findById().
     */
    @Test
    public void whenFindByIdThenReturnResult() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L);
        tracker.add(item1);
        Item result = tracker.findById(item1.getId());
        assertThat(result.getDesc(), is("testDescription"));

    }
}