package ru.job4j.max;

public class Max {
    public int max(int first, int second){

        int s = first - second;
        if (s<0 )
            return second;
        else
        return first;
    }
    public int max(int first, int second, int third){
    return Math.max(Math.max(first, second), third);
    }

}
