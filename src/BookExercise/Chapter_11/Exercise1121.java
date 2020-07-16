package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1121 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /* Напишите класс, который вначале принимает с клавиатуры целое положительное число (в переменную х). Затем класс
         выводит на экран в строку серию из 17 целых положительных чисел, отвечающую следующим условиям:
        1) серия начинается с числа, большего хна 1;
        2) каждое число в серии (начиная со второго) больше предьщущего на 1*/
        int x = scan.nextInt();
        int count = 0;
        while (count < 17) {
            x++;
            System.out.print(x + " ");
            count++;
        }

    }
}
