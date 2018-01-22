package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

    @Test
    public void removeArrayDupl() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Мир", "Мир", "Привет", "Супер", "Супер", "Супер", "Мир"};
        String[] resultArray = arrayDuplicate.remove(array);
        String[] expectArray = {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expectArray));
    }
}