package ru.job4j.tracker;

/**
 *Класс-оболочка для полей Item.
 * @version 1
 * @since 0.1
 */
public class Item extends Tracker{
    private String id;
    private  String name;
    private  String desc;
    private long created;
    private String[] comments;

    public Item() {
    }
    /**
     * Конструктор.
     *  //@param id идентификатор заявки.
     * @param name имя заявки.
     * @param desc дата создания заявки.
     */
    public Item( String name, String desc) {
        this.id = getId();
        this.name = name;
        this.desc = desc;
        this.created = System.currentTimeMillis();
    }
    /**
     * Метод сеттер, устанавливает значение id.
     *@return Уникальный ключ.
     */
    public String setId(String genId) {
        this.id = genId;
        return genId;
    }
    /**
     * Метод геттер, возвращает значение name.
     * @return Имя заявки.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Метод геттер, возвращает значение id.
     * @return Уникальный ключ.
     */
    public String getId(){
        return this.id;
    }
    /**
     * Метод геттер, возвращает значение created.
     * @return Дата создания заявки.
     */
    public long getCreated(){
        return this.created;
    }

}
