package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_935 {
    static Scanner scan = new Scanner(System.in);

    // http://foxtools.ru/Unicode
    /* Напишите класс, который читает с клавиатуры символ и проверяет, является ли введенный символ буквой латинского алфавита.*/
    public static void main(String[] args) {
        char c = scan.nextLine().charAt(0);
        if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) System.out.println("буква");
        else System.out.println("Нет");
        System.out.println(checkChar(c));


    }

    public static boolean checkChar(char c) { // Решение предлагалось в задачнике. Неправильно
        // Отмечает буквами символы: [ \ ] ^ _ '
        if (c >= 'A' && c <= 'z') return true;
        return false;
    }
}
