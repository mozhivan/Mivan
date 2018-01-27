package ru.job4j.Shape;

public class Paint {
    private int size;

    public Paint(int size){
        this.size = size;
    }

    public void draw(Shape shape){
        System.out.println(shape.draw(size));
    }
    public void setSize(int value){
        this.size = value;
    }
    public int getSize(){
        return this.size;
    }

}
