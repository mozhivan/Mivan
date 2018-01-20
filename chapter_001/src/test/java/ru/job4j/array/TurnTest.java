package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TurnTest {

    @Test
    public void sixElemArrayBack() {
        Turn turn = new Turn();
        int[] array = { 1, 2, 3, 4, 5, 6 };
        int[] resultArray = turn.back(array);
        int[] expectArray = new int[] { 6, 5, 4, 3, 2, 1 };
        assertThat(resultArray, is(expectArray));
        }

    @Test
    public void nineElemArrayBack() {
        Turn turn = new Turn();
        int[] array = { 52, 56, 54, 57, 59, 60, 69, 67, 64, 66, 62 };
        int[] resultArray = turn.back(array);
        int[] expectArray = new int[] { 62, 66, 64, 67, 69, 60, 59, 57, 54, 56, 52 };
        assertThat(resultArray, is(expectArray));
    }
}