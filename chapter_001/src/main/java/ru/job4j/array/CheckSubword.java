package ru.job4j.array;

public class CheckSubword {
    private boolean contains;

    public boolean contains(String origin, String sub){
        char[] originChars = origin.toCharArray();
        char[] subChars = sub.toCharArray();

        for (int i = 0; i <= originChars.length - subChars.length; i++){
            int s = i;
            for (int j=0; j < subChars.length; j++){
                if (originChars[s] == subChars[j]){
                    s++;
                    contains = true;
                }
                else {
                    contains = false;
                    break;
                }
            }
            if (contains){
                break;
            }
        }
        return contains;
    }
}



