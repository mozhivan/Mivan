package ru.job4j.tracker.models;

/**
 *Класс-оболочка для полей Item.
 * @version 1
 * @since 0.1
 */
public class Item {
    private String id;
    private  String name;
    private  String desc;
    private long created;
    private String[] comments;

    public Item() {
    }
    /**
     * Конструктор.
     * @param created дата создания заявки.
     * @param name имя заявки.
     * @param desc дата создания заявки.
     */
    public Item( String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    /**
     * Конструктор.
     *
     * @param name имя заявки.
     * @param desc дата создания заявки.
     */
    public Item( String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    /**
     * Метод сеттер, устанавливает значение id.
     *@return Уникальный ключ.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Метод геттер, возвращает значение name.
     * @return Имя заявки.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Метод геттер, возвращает значение desc.
     * @return Описание заявки.
     */
    public String getDesc(){
        return this.desc;
    }
    /**
     * Метод сеттер, устанавливает значение desc.
     */
    public void setDesc(String desc) {
        this.desc = desc;
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
