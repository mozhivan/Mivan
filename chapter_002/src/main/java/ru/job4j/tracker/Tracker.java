package ru.job4j.tracker;
/**
 * Package for calculate task.
 *
 * @author Ivan Mozheiko (mozhivan@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище и присваивает ей уникальный id.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId(item));
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод реализаущий замену заявки в хранилище на другую, поиск заявки происходит по id.
     * @param item измененая заявка
     */
    public void replace(String id, Item item){
        for (int i = 0; i < this.items.length; i++){
            if (this.items[i].getId().equals(id)){
        this.items[i] = item;
            }
        }

    }
    /**
     * Метод реализаущий удаление заявки из хранилища, поиск заявки происходит по id.
     * @param id ключ удаляемой заявки.
     */
    public void delete(String id){
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)){
                System.arraycopy(this.items,i + 1,this.items,i,this.items.length - i);
                break;
            }
        }
    }
    /**
     * Метод реализаущий поиск всех заявок из хранилища.
     * @return массив this.items без null элементов;.
     */
    public Item[] findAll(){
        Item[] item = new Item[this.position];
        System.arraycopy(this.items,0,item,0,item.length);
        return item;
    }
    /**
     * Метод реализаущий поиск заявок по имени.
     * @param key имя заявки.
     * @return массив найденных заявок с данным именем.
     */
    public Item[] findByName(String key){
        int f = 0;
        Item[] item = new Item[this.position];
        for (int i = 0; i < this.items.length; i++){
            if (this.items[i].getName().equals(key)) {
                item[f] = this.items[i];
                f++;
            }
        }
        System.arraycopy(item,0,item,0,f + 1);
        return item;
    }
    /**
     * Метод реализаущий поиск заявок по id.
     * @param id уникальный код заявки.
     * @return заявка item с данным id.
     */
    public Item findById(String id){
        Item item = new Item();
        for (int i = 0; i < this.items.length; i++){
            if (this.items[i].getId().equals(id)){
                item = items[i];
            }
            else{
                item = null;
            }
        }
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Ключ будет строкой, состоять из даты создания и случайного числа от 100 до 999.
     * @return Уникальный ключ.
     */
    private String generateId(Item item) {
        Integer a = 100 + (int)(Math.random()*899);
        Long c = item.getCreated();
        return c.toString() + a.toString();
    }


}
