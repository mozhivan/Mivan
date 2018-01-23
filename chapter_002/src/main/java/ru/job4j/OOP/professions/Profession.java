package ru.job4j.OOP.professions;

public class Profession {
    String diplomOfUniversity;
    String name;
    String workResults;
    int [][] workSchedule;
    boolean overtime;
public boolean goToWorkToday(int[][] workSchedule, int day){
    if (workSchedule[day] == null) {
        return false;
    }
    return true;
}

public String work(String workResults){
    return workResults;
}
public String getName(String name){
    return name;
}
}
