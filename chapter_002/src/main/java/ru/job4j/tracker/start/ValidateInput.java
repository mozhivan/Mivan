package ru.job4j.tracker.start;

public class ValidateInput extends ConsoleInput {
public int ask(String question, int[] range) {
    boolean invalid = true;
    int value = - 1;
    do {
        try {
            value = super.ask(question, range);
            invalid = false;
        }
        catch (MenuOutExeption moe) {
            System.out.println("Ошибка ввода числа. Пожалуйста введите номер пункта из меню");
        } catch (NumberFormatException nfe) {
            System.out.println("Вы ввели некорректные данные. Пожалуйста введите номер пункта из меню");
        }
    } while (invalid);
    return value;
}
}
