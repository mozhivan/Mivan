package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription");
        Item next = new Item("test2","testDescription2");
        tracker.add(previous);
        next.setId(previous.getId());
        tracker.replace(next.getId(),previous);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }


    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void findById() {
    }
}