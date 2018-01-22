package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckSubwordTest {

    @Test
    public void contains() {
        CheckSubword check = new CheckSubword();
        boolean result = check.contains("привет","рив");
        assertThat(result, is(true));
    }
}