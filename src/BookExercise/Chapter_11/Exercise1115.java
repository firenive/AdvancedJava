package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1115 {
    /* Напишите класс, который выводит на экран в строку все положительные двузначные четные числа (в возрастающем
     порядке). Числа должны отделяться друг от друга знаком «пробел». Перед началом и после окончания вывода серии чисел
      на экран вывода следует вывести текстовые сообщения (по выбору).*/
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Старт");
        for (int i = 10; i <99; i++) {
            if (i %2 ==0) System.out.print(i + " ");

        }
        System.out.println("\nФиниш");
    }
}
