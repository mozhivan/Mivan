package ru.job4j.tracker.start;
import ru.job4j.tracker.models.*;

/**
 *  @author Ivan Mozheiko (mozhivan@yandex.ru)
 * @version 1.2
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String FINDALL = "1";
    /**
     * Константа меню для изменения заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для отображения всех заявок с заданным именем.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа меню для выхода из программы.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            }
            else if(FINDALL.equals(answer)){
                this.findAllItems();
            }
            else if(EDIT.equals(answer)){
                this.editItem();
            }
            else if(DELETE.equals(answer)){
                this.deleteItem();
            }
            else if(FINDBYID.equals(answer)){
                this.findByID();
            }
            else if(FINDBYNAME.equals(answer)){
                this.findByNAME();
            }
            else if(EXIT.equals(answer)){
                exit = true;
            }

        }
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка успешно добавлена! Id заявки : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует отображения всех заявок.
     */
    private void findAllItems() {
        System.out.println("------------ Показать все заявки --------------");
        Item[] result = this.tracker.findAll();
        for (Item i : result){
            System.out.println("Id заявки : " + i.getId() + "  Имя заявки : " + i.getName() + "  Описание заявки : " + i.getDesc());
        }
        System.out.println("------------ Конец списка -----------");
    }
    /**
     * Метод реализует изменение описания заявки и сохраниние ее в хранилище по id вместо другой заявки.
     */
    private void editItem() {
        System.out.println("------------ Изменение заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item  = this.tracker.findById(id);
        String desc = this.input.ask("Введите новое описание заявки :");
        item.setDesc(desc);
        String idReplace = this.input.ask("Введите id заявки, которую хотите заменить:");
        this.tracker.replace(idReplace,item);
        System.out.println("------------ Заявка успешно изменена! Id заявки : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует удаление заявки из хранилища по id.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
        System.out.println("------------ Заявка успешно удалена! -----------");
    }
    /**
     * Метод реализует поиск заявки в хранилище по id.
     */
    private void findByID() {
        System.out.println("------------ Поиск заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item result = this.tracker.findById(id);
        System.out.println("Id заявки : " + result.getId() + "  Имя заявки : " + result.getName() + "  Описание заявки : " + result.getDesc());
    }
    /**
     * Метод реализует отображения всех заявок.
     */
    private void findByNAME() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] result = this.tracker.findByName(name);
        for (Item i : result){
            System.out.println("Id заявки : " + i.getId() + "  Имя заявки : " + i.getName() + "  Описание заявки : " + i.getDesc());
        }
        System.out.println("------------ Конец списка -----------");
    }
    /**
     * Метод отображающий меню пользователя.
     */
    private void showMenu() {
        System.out.println("----------- Меню -----------");
        System.out.println("0. Добавление новой заявки");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Изменить заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по id");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выйти из программы");
    }
    public static void main(String[] args){
        ConsoleInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input,tracker).init();
    }
}
