package ru.job4j.Shape;

import java.util.function.BiPredicate;

public class Triangle implements Shape {

  @Override
    public String pic(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    @Override
    public String draw(int height){
        return  pic(height);
    }

    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append("" +
                    "");
        }
        return screen.toString();
    }
}
