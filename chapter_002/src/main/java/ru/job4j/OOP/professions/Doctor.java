package ru.job4j.OOP.professions;

public class Doctor extends Profession {
    String aHippocraticOath;
    Doctor nick = new Doctor();
    String name = nick.getName("Nick");
    private boolean motivateDocrors(String aHippocraticOath){
        return true;
    }
private String doAdministrations(){
        return nick.work("administrations");
}
}
