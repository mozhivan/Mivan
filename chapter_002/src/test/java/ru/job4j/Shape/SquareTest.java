package ru.job4j.Shape;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {

    @Test
    public void whenDrawThenSquare() {
        Square square = new Square();
        assertThat(
                square.draw(4),
                is(
                        new StringBuilder()
                                .append("XXXX")
                                .append("XXXX")
                                .append("XXXX")
                                .append("XXXX")
                                .toString()
                )
        );
    }
}