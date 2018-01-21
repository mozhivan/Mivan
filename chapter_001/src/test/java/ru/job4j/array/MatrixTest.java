package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void multipleSixByEight() {
        Matrix mat = new Matrix();
        int[][] matrix = mat.multiple(10);
        int result = matrix[6][8];
        assertThat(result, is(48));
        }
    @Test
    public void multipleTwoByTwo() {
        Matrix mat = new Matrix();
        int[][] matrix = mat.multiple(10);
        int result = matrix[2][2];
        assertThat(result, is(4));
    }
}