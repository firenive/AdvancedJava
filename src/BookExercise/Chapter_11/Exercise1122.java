package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1122 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /* Напишите класс, который вначале принимает с клавиатуры целое положительное число (в переменную х). Затем класс
         выводит на экран в строку серию из 17 целых положительных чисел, отвечающую следующим условиям:
        1) серия начинается с числа, меньшего хна 10;
        2) каждое число в серии (начиная со второго) меньше предыдущего на 6.*/
        int x = scan.nextInt();
        int temp = 10;
        int count = 0;
        while (count < 17) {
            x = x - temp;
            System.out.print(x + " ");
            temp = 6;
            count++;
        }

    }
}
