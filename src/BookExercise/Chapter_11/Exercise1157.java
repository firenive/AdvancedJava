package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1157 {
    /* Напишите класс, который принимает с клавиатуры целое число а, а затем выводит на экран серию из 15 целых чисел,
    начиная с 1 так, что каждое следующее число в серии на а больше предыдущего числа (между числами должен быть знак#)*/
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int a = scan.nextInt();
        int temp = 1;
        int n1, n2;
        for (int i = 1; i <=15; i++) {
            temp+=a;
            System.out.print(temp + " # ");

        }

    }

}

