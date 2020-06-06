package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_926 {
    static Scanner scan = new Scanner(System.in);
    /* Назовем двузначное число «внутренним» по отношению к четырехзначному числу, если какая-то пара смежных цифр в четырехзначном
    числе образует двузначное число. Напишите класс, который принимает с клавиатуры два положительных числа - двузначное
     и четырехзначное - и проверяет, является ли двузначное «внутренним» по отношению к четырехзначному.*/
    public static void main(String[] args) {
        int digit2 = scan.nextInt();
        int digit4 = scan.nextInt();
        int n1 = digit4 / 100;
        int n2 = digit4  / 10 % 100;
        int n3 = digit4 % 100;
        int[] numbers = {n1, n2, n3};
        int count = 0;
        for (int x : numbers) {
            if (x == digit2) count++;
        }
        System.out.println(count);

    }
}
