package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void calc() {
        Factorial count = new Factorial();
        int result = count.calc(5);
        assertThat(result, is(120));
    }
    @Test
    public void calc0() {
        Factorial count = new Factorial();
        int result = count.calc(0);
        assertThat(result, is(1));
    }
}