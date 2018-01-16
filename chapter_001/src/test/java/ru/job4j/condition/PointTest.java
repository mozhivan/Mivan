package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void testDistanceFromAToB() {
     Point a = new Point(2,24);
     Point b = new Point(2,54);
        double result = a.distanceTo(b);
        assertThat(result, is(30.0));
    }
}