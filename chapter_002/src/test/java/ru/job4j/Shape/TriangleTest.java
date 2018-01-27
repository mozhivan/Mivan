package ru.job4j.Shape;

import org.junit.Test;

        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(3),
                is(
                        new StringBuilder()
                                .append("  ^  ")
                                .append(" ^^^ ")
                                .append("^^^^^")
                                .toString()
                )
        );
    }
}
