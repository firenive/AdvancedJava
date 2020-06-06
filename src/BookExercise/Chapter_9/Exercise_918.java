package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_918 {
    static Scanner scan = new Scanner(System.in);
    /*Напишите класс, который принимает с клавиатуры три числа и проверяет, являются ли эти числа длинами сторон одного
    и того же треугольника*/
    public static void main(String[] args) {
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        if (a + b < c || a + c < b || c + b < a) System.out.println("Числа не являются длинами треугольника");
        else System.out.println("да");

    }
}
