package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max max = new Max();
        int result = max.max(3,10);
        assertThat(result, is(10));

    }
    @Test
    public void whenFirstAndThirdLessThenSecond() {
        Max max = new Max();
        int result = max.max(555,125, 22);
        assertThat(result, is(555));

    }
}