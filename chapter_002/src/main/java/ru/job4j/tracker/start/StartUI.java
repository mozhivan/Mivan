package ru.job4j.tracker.start;
/**
 *  @author Ivan Mozheiko (mozhivan@yandex.ru)
 * @version 1.2
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Массив допустимых значений меню.
     */
    private int[] range;
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
        this.range = new int[]{0,1,2,3,4,5};
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input,this.tracker);
        menu.fillActions();
        boolean exit = false;
        String yes = "y";
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Выберете пункт меню : ",this.range));
            menu.select(key);
            if (yes.equals(this.input.ask("Вы хотите выйти? y/n"))){
                exit = true;
            }
        } while (!exit);
    }

    public static void main(String[] args){
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        new StartUI(input,tracker).init();
    }
}
