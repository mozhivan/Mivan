package ru.job4j.tracker;

import java.util.*;

/**
 *Класс Tracker - хранилище для хранения заявок и выполнения операций над ними.
 *
 * @author Ivan Mozheiko (mozhivan@yandex.ru)
 * @version 1.2
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private static final Random RN = new Random();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище и присваивает ей уникальный id.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод реализаущий замену заявки в хранилище на другую, поиск заявки происходит по id.
     * @param item измененая заявка
     */
    public void replace(String id, Item item){
        for (int i = 0; i < this.items.length; i++){
            if (this.items[i]!=null&&this.items[i].getId().equals(id)){
                this.items[i] = item;
            }
        }

    }
    /**
     * Метод реализаущий удаление заявки из хранилища, поиск заявки происходит по id.
     * @param id ключ удаляемой заявки.
     */
    public void delete(String id){
        for (int i = 0; i < this.position; i++) {
            if (this.items[i]!=null&&this.items[i].getId().equals(id)){
                System.arraycopy(this.items,i + 1,this.items,i,position - i);
                break;
            }
        }
    }
    /**
     * Метод реализаущий поиск всех заявок из хранилища.
     * @return массив this.items без null элементов;.
     */
    public Item[] findAll(){
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++){
            result[i] = this.items[i];
        }
        return result;
    }
    /**
     * Метод реализаущий поиск заявок по имени.
     * @param key имя заявки.
     * @return массив найденных заявок с данным именем.
     */
    public Item[] findByName(String key){
        int find = 0;
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.items.length; i++){
            if (this.items[i]!=null&&this.items[i].getName().equals(key)) {
                result[find] = this.items[i];
                find++;
            }
        }
        return Arrays.copyOf(result,find);
    }
    /**
     * Метод реализаущий поиск заявок по id.
     * @param id уникальный код заявки.
     * @return заявка item с данным id.
     */
    public Item findById(String id){
        Item result = null;
        for (Item item : this.items){
            if (item!=null&&item.getId().equals(id)){
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Ключ будет строкой, состоять из даты создания и случайного числа от 100 до 999.
     * @return Уникальный ключ.
     */
    String generateId() {

        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }


}
