package BookExercise.Chapter_12;

import java.util.Scanner;

public class Exercise126 {
    /* Напишите класс, который принимает с клавиатуры целое число и проверяет, на какое количество двузначных чисел оно делится.
     Результат проверки класс должен вывести на экран вместе с соответствующим текстовым сообщением.*/
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int x, count = 0;
        x = scan.nextInt();
        for (int i = 10; i <= 99; i++) {
            if (x % i ==0) count++;

        }
        System.out.println("Количество делителей: " + count);
    }
}
