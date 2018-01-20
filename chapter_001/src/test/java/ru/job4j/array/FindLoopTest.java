package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    Square square = new Square();
    FindLoop find = new FindLoop();
    int[] dat = square.calculate(10);

    @Test
    public void findIndexOf100() {
        int result = find.indexOf(dat, 100);
        assertThat(result, is(9));
    }

    @Test
    public void findIncorrectIndex() {
        int result = find.indexOf(dat, 33);
        assertThat(result, is(-1));
    }

    @Test
    public void indexOfFourPlusIndexOf100equalsTen() {
        int result = find.indexOf(dat, 4) + find.indexOf(dat, 100);
        assertThat(result, is(10));
    }
}