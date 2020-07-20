package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1160 {
    /*Напишите класс, который принимает с клавиатуры целое число N, а затем выводит на экран все степени двойки от 1 до
     N включительно.*/
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        for (int i = 0; i <=n; i++)
        System.out.println((int) Math.pow(2,i));
    }
}
