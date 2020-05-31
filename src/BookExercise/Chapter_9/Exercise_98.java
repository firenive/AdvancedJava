package BookExercise.Chapter_9;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise_98 {
    static Scanner scan = new Scanner(System.in);
    // Назовем билет с шестизначным номером «счастливым», если сумма первых трех его цифр равна сумме последних трех его
    // цифр и обе эти суммы являются четными. Напишите класс, который принимает с клавиатуры шестизначный номер билета
    // и проверяет, является ли он «счастливым» или не является.

    public static void main(String[] args) {
        int x = scan.nextInt();
        int[] b = new int[6];
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = x % 10;
            x = x / 10;
            if (i < 3) n1 += b[i];
            else if (i >= 3) n2 += b[i];
        }
        if ((n1 == n2) & (n1 % 2 == 0 & n2 % 2 == 0)) System.out.println("Билет счастливый");
        else System.out.println("Билет несчастливый");
    }
}
