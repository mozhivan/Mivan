package ru.job4j.Shape;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Ivan Mozheiko (mozhivan@yandex.ru)
 * @version 1.1
 * @since 0.1
 */
public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput(){
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput(){
        System.setOut(stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenDrawSquare() {
        Paint paint = new Paint(5);
        paint.draw(new Square());
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("XXXXX")
                                .append("XXXXX")
                                .append("XXXXX")
                                .append("XXXXX")
                                .append("XXXXX")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawTriangle() {
        Paint paint = new Paint(4);
        paint.draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   ^   ")
                                .append("  ^^^  ")
                                .append(" ^^^^^ ")
                                .append("^^^^^^^")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}