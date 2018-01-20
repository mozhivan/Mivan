package ru.job4j.loop;

public class Factorial {
    int rsl = 1;

    public int calc(int n) {

        for (int i = 1; i <= n; i++) {

            rsl *= i;
        }
        return rsl;
    }
}

