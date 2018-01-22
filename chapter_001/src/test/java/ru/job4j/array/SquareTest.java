package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SquareTest {
    @Test
    public void FifthhElemEquals25() {
        Square square = new Square();
        int[] m = square.calculate(5);
        int result = m[4];
        assertThat(result, is(25));
    }

    @Test
    public void firstElemPlusTenthEqualsd101() {
        Square square = new Square();
        int[] m = square.calculate(10);
        int result = m[0] + m[9];
        assertThat(result, is(101));
    }


    @Test
    public void arrayTest() {
        Square square = new Square();
        int[] resultArray = square.calculate(4);
        int [] expectArray = { 1, 4, 9, 16};
        assertThat(resultArray, is( expectArray));
    }
}