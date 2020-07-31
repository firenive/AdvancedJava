package BookExercise.Chapter_12;

import java.util.Scanner;

public class Exercise125 {
    /*Напишите класс, который генерирует 15 целых чисел в интервале от -25 до 25, печатает их, а затем выводит на экран
     информацию о том, сколько из них были:
     • положительными;
     • четными;
     • однозначными.*/

    public static void main(String[] args) {
        int countPos = 0, countNeg = 0, countDigit = 0, tmp;
        for (int i = 0; i < 15; i++) {
            tmp = -25 + (int) (Math.random() * 51);
            if (tmp < 0) countNeg++;
            if (tmp > -9 && tmp < 9) countDigit++;
            if (tmp > 0) countPos++;
            System.out.print(tmp + " ");

        }
        System.out.println("\nКоличество отрицательных: " + countNeg);
        System.out.println("Количество положительных: " + countPos);
        System.out.println("Количество однозначных: " + countDigit);
    }
}
