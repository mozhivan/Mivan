package ru.job4j.condition;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @author Ivan Mozheiko (mozhivan@yandex.ru)
     * Вычисляет расстояние от одной точки до другой.
     *
     * Point b в методе вообще не нужен.
     * А переменные int x1,x2,y1,y2 можно можно задать сразу в формуле.
     *
     */
    public double distanceTo(Point that) {
        Point a = this;
        double result = Math.sqrt(Math.pow(that.x - a.x, 2) + Math.pow(that.y - a.y, 2)
        );
        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(16, 5);
        Point b = new Point(67, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}