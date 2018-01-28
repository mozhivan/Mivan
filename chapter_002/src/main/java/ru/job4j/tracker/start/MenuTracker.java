package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions(){
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.FindAllItems();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindByIDItem();
        this.actions[5] = new MenuTracker.FindByNameItem();
        }
    public void select(int key){
        this.actions[key].execute(this.input, this.tracker);
    }
    public void show(){
        System.out.println("----------- Меню ----------- ");
        for (UserAction action:this.actions) {
            System.out.println(action.info() + " ");
        }
    }

    /**
     * Внутренний класс реализующий добавление новой заявки.
     */
    private class AddItem implements UserAction{
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка успешно добавлена! Id заявки : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавление новой заявки");
        }
    }
    /**
     * Внутренний класс реализующий вывод всех заявок.
     */
    private static class FindAllItems implements UserAction{
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.print("------------ Показать все заявки -------------- ");
            for (Item item : tracker.findAll()) {
                System.out.print("Id заявки : " + item.getId() + "  Имя заявки : " + item.getName() + "  Описание заявки : " + item.getDesc() + " ");
            }
            System.out.print("------------ Конец списка ----------- ");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки");
        }
    }
    /**
     *Внутренний класс реализующий изменение описания заявки и сохраниние ее в хранилище по id вместо другой заявки.
     */
    private class EditItem implements UserAction{
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменение заявки --------------");
            String id = input.ask("Введите id заявки :");
            Item item  = tracker.findById(id);
            String desc = input.ask("Введите новое описание заявки :");
            item.setDesc(desc);
            String idReplace = input.ask("Введите id заявки, которую хотите заменить:");
            tracker.replace(idReplace,item);
            System.out.println("------------ Заявка успешно изменена! Id заявки : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Изменить заявку");
        }
    }
    /**
     * Внутренний класс реализует удаление заявки из хранилища по id.
     */
    private class DeleteItem implements UserAction{
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            tracker.delete(id);
            System.out.println("------------ Заявка успешно удалена! -----------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку");
        }
    }
    /**
     * Внутренний класс реализует поиск заявки по id.
     */
    private class FindByIDItem implements UserAction{
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки --------------");
            String id = input.ask("Введите id заявки :");
            Item result = tracker.findById(id);
            System.out.println("Id заявки : " + result.getId() + "  Имя заявки : " + result.getName() + "  Описание заявки : " + result.getDesc());
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по id");
        }
    }
    /**
     * Внутренний класс реализующий поиск заявок по имени.
     */
    private static class FindByNameItem implements UserAction{
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени -------------- ");
            String name = input.ask("Введите имя заявки :");
            Item[] result = tracker.findByName(name);
            for (Item i : result){
                System.out.print("Id заявки : " + i.getId() + "  Имя заявки : " + i.getName() + "  Описание заявки : " + i.getDesc() + " ");
            }
            System.out.println("------------ Конец списка ----------- ");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по имени");
        }
    }
}
