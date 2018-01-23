package ru.job4j.OOP.professions;

public class Engineer extends Profession {
int deepKnowledge = 2*2;
double calculationResults;
Engineer john = new Engineer();
String name = john.getName("John");
private double makeProject(int deepKnowledge){
    calculationResults = deepKnowledge*3.14;
    return calculationResults;
}
 private String visitDoctor(Doctor Nick){
    Doctor nick = new Doctor();
    String rsl = nick.work("Administration for " + name);
    return rsl;
 }
}
