package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_931 {
    static Scanner scan = new Scanner(System.in);

    /* Напишите класс, который принимает с клавиатуры четырехзначное число, которое должно определять некоторый год в
    период с 16 по 20 века включительно.*/
    public static void main(String[] args) {
        int year = scan.nextInt();
        if (1501 <= year && year <= 2000) {
            if (year % 100 == 0) System.out.println((year / 100) + " Век");
            else System.out.println(year / 100 + 1 + " Век");
        } else System.out.println("неправильный год");


    }
}
