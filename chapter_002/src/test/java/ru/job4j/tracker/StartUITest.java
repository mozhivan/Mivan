package ru.job4j.tracker;


import org.junit.Test;
import ru.job4j.tracker.start.*;
import ru.job4j.tracker.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирует действия пользователя в меню.
 * Тестируемый класс StartUI.
 */
public class StartUITest {
    /**
     * Тест добавления новой заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    /**
     * Тест изменения описания заявки.
     */
    @Test
    public void whenEditThenTrackerHasEditedValue() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1","desc1"));
        Item item2 = tracker.add(new Item("test name2","desc2"));
        Input input = new StubInput(new String[]{"2", item1.getId(), "new test desc", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item1.getId()).getDesc(), is("new test desc"));
    }
    /**
     * Тест удаления заявки.
     */
    @Test
    public void whenDeleteThenFindNull() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1","desc1"));
        String id = item1.getId();
        Item rsl = null;
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id), is(rsl));
    }
    /**
     * Тест поиска заявки по id.
     */
    @Test
    public void whenFindByIDThenTrackerHasItemWithSameName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1","desc1"));
        String id = item1.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id).getName(), is("test name1"));
    }
}