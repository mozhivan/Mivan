package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array){
        int length = array.length;
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++) {
                if (array[i].equals(array[j])){
                    array[j] = array[length - 1];
                    length--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array,length);
    }
}
