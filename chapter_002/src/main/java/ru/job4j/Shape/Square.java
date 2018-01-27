package ru.job4j.Shape;

/**
 *
 */
public class Square implements Shape {
@Override
    public String pic(int height){
        StringBuilder screen = new StringBuilder();
        for (int i = 1; i <= height; i++){
            for (int j = 1; j <= height; j++){
                    screen.append("X");
            }
            screen.append("" +
                    "");
        }
        return screen.toString();
    }
@Override
    public String draw(int height){
    return  pic(height);
}
}
