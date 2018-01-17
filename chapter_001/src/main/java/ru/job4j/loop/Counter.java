package ru.job4j.loop;

public class Counter {
    int rsl = 0;
    public int add(int start, int finish) {
        for(int i=start; i<= finish; i++){
            if (i % 2==0){
                rsl += i;
            }
        }
        return rsl;
    }
}
