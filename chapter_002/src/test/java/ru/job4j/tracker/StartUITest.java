package ru.job4j.tracker;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.Input;
import ru.job4j.tracker.start.StartUI;
import ru.job4j.tracker.start.StubInput;
import ru.job4j.tracker.start.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирует действия пользователя в меню.
 * Тестируемый класс StartUI.
 */
public class StartUITest {
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * Поле содержит буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Метод заменяет стандартный вывод на вывод в буфер для тестирования.
     */
    @Before
    public void loadOutput(){
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Метод возвращает обратно стандартный вывод в консоль.
     */
    @After
    public void backOutput(){
        System.setOut(stdout);
        System.out.println("execute after method");
    }
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
    /**
     * Тест поиска заявки по имени.
     */
    @Test
    public void whenFindByNameThenTrackerHasItemWithSameName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1","desc1"));
        Item item2 = tracker.add(new Item("name2","desc2"));
        Item item3 = tracker.add(new Item("name1","desc3"));
        Item item4 = tracker.add(new Item("name1","desc4"));
        item1.setId("testId1");
        item3.setId("testId3");
        item4.setId("testId4");
        Input input = new StubInput(new String[]{"5", "name1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("----------- Меню -----------")
                                .append("0. Добавление новой заявки")
                                .append("1. Показать все заявки")
                                .append("2. Изменить заявку")
                                .append("3. Удалить заявку")
                                .append("4. Найти заявку по id")
                                .append("5. Найти заявку по имени")
                                .append("6. Выйти из программы")
                                .append("------------ Поиск заявки по имени --------------")
                                .append("Id заявки : testId1  Имя заявки : name1  Описание заявки : desc1")
                                .append("Id заявки : testId3  Имя заявки : name1  Описание заявки : desc3")
                                .append("Id заявки : testId4  Имя заявки : name1  Описание заявки : desc4")
                                .append("------------ Конец списка -----------")
                                .append("----------- Меню -----------")
                                .append("0. Добавление новой заявки")
                                .append("1. Показать все заявки")
                                .append("2. Изменить заявку")
                                .append("3. Удалить заявку")
                                .append("4. Найти заявку по id")
                                .append("5. Найти заявку по имени")
                                .append("6. Выйти из программы")
                                .toString()
                )
        );
    }
    /**
     * Тест поиска всех заявок.
     */
    @Test
    public void whenFindAllThenTrackerHasAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1","desc1"));
        Item item2 = tracker.add(new Item("test name2","desc2"));
        Item item3 = tracker.add(new Item("test name3","desc3"));
        Item item4 = tracker.add(new Item("test name4","desc4"));
        item1.setId("testId1");
        item2.setId("testId2");
        item3.setId("testId3");
        item4.setId("testId4");
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("----------- Меню -----------")
                                .append("0. Добавление новой заявки")
                                .append("1. Показать все заявки")
                                .append("2. Изменить заявку")
                                .append("3. Удалить заявку")
                                .append("4. Найти заявку по id")
                                .append("5. Найти заявку по имени")
                                .append("6. Выйти из программы")
                                .append("------------ Показать все заявки --------------")
                                .append("Id заявки : testId1  Имя заявки : test name1  Описание заявки : desc1")
                                .append("Id заявки : testId2  Имя заявки : test name2  Описание заявки : desc2")
                                .append("Id заявки : testId3  Имя заявки : test name3  Описание заявки : desc3")
                                .append("Id заявки : testId4  Имя заявки : test name4  Описание заявки : desc4")
                                .append("------------ Конец списка -----------")
                                .append("----------- Меню -----------")
                                .append("0. Добавление новой заявки")
                                .append("1. Показать все заявки")
                                .append("2. Изменить заявку")
                                .append("3. Удалить заявку")
                                .append("4. Найти заявку по id")
                                .append("5. Найти заявку по имени")
                                .append("6. Выйти из программы")
                                .toString()
                )
        );
    }
}