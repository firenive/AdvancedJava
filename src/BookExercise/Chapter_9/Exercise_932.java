package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_932 {
    static Scanner scan = new Scanner(System.in);

    /* Напишите класс, который принимает с клавиатуры четырехзначное число и проверяет, означает ли оно один из
    високосных годов 20 века.*/
    public static void main(String[] args) {
        int year = scan.nextInt();
        int n = year % 100;
        if (n % 4 == 0) System.out.println("Високосный");
        else System.out.println("Невисокосный");



    }
}
