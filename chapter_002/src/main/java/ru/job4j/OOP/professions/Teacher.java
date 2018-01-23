package ru.job4j.OOP.professions;

public class Teacher extends Profession {
    int phoneNumber = 222444111;
    int mathConstant = 10;
    Teacher ann = new Teacher();
    boolean studentAnswer = ann.askStudent(10);
    public int callToFriend(int phoneNumber, Engineer john){
        return phoneNumber;
    }
    private boolean askStudent(int answer){
        if (answer != mathConstant){
            return false;
        }
        return true;
    }

    private int rateStudent(){
        final int five = 5;
        final int two = 2;
        if (studentAnswer){
            return five;
        }
        return two;
    }
}
