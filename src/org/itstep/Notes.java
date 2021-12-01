package org.itstep;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Stack;

public class Notes {
    static int number;

    public static void main(String[] args) throws Exception {
        number = 110;
        Department department1 = new Department("Отд. " + number);
        Letter letter1 = new Letter(
                "Служебная записка №1",
                "10.11.2021",
                "начальника отдела Васильева В.К.",
                Integer.toString(number),
                "Главному инженеру",
                "Пояснения");
        Letter letter2 = new Letter(
                "Предписание №1",
                "11.11.2021",
                "начальника ТБ Петрова П.И.",
                Integer.toString(number),
                "Главному технологу",
                "на утверждение");
        Letter letter3 = new Letter(
                "Заявление на отпуск",
                "12.11.2021",
                "мастера участка Иванова П.И.",
                Integer.toString(number),
                "В отдел кадров",
                "Согласование на отпуск");
        department1.addLetter(letter1);
        department1.addLetter(letter2);
        department1.addLetter(letter3);
        department1.sortLetterDep();
        System.out.println(department1);

        number = 140;
        Department department2 = new Department("Отд. " + number);
        Letter letter4 = new Letter(
                "Служебная записка № 10",
                "12.11.2021",
                "начальника ТБ Ильина С.И.",
                Integer.toString(number),
                "Главному технологу",
                "пояснения");
        Letter letter5 = new Letter(
                "Заявление на отпуск",
                "12.11.2021",
                "наладчика КИПиА Сидорова С.Т.",
                Integer.toString(number),
                "В отдел кадров",
                "Согласование на отпуск");
        department2.addLetter(letter4);
        department2.addLetter(letter5);
        department2.sortLetterDep();
        System.out.println(department2);

        number = 170;
        Department department3 = new Department("Отд. " + number);
        Letter letter6 = new Letter(
                "Служебная записка № 25",
                "14.11.2021",
                "Начальник ТБ отдела",
                Integer.toString(number),
                "Главному технологу",
                "пояснения");
        Letter letter7 = new Letter(
                "Заявление на отпуск",
                "15.11.2021",
                "Рабочий",
                Integer.toString(number),
                "В отдел кадров",
                "Согласование на отпуск");
        department3.addLetter(letter6);
        department3.addLetter(letter7);
        department3.sortLetterDep();
        System.out.println(department3);

        Stack<Department> depStack = new Stack<>();
        depStack.push(department1);
        depStack.push(department2);
        depStack.push(department3);

        if (depStack.isEmpty() == false) {
            System.out.println("Поступил пакет документов из " + depStack.size() + " отделов");
            System.out.println();

            System.out.println("Входящая почта отдела ОТД: ");
            while (depStack.size() > 0) {
                String s = depStack.pop().toString();
                StringReader reader = new StringReader(s);
                executor(reader);
            }
        }
        if (depStack.isEmpty() == true) {
            System.out.println();
            System.out.println("Входящей новой почты нет");
        }
    }

    public static void executor(Reader reader) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String lineBr = null;
        do {
            String line = br.readLine();
            if ((line != null) && (line.indexOf("Исходящие документы") == -1)) {
                System.out.println(line);
            }
            lineBr = line;
        } while (lineBr != null);
    }
}
