package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1137 {
    /*Напишите класс, который генерирует 20 случайных чисел из диапазона от-18до 18. Для каждого отрицательного числа
    следует вывести на экран само число и его квадрат (в одной строке), для положительного - само число и округленный
    (по правилам округления, принятым в математике) корень из числа. Значения, равные нулю, не выводятся на экран
    вообще.*/
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int random = -18 + (int) (Math.random()* 37);
            double sqrt;
            if(random < 0) {
                System.out.println("Отрицательное число: " + random +
                        " Квадрат отрицательного числа: " + (random * random));
            }
            else if(random > 0) {
                sqrt = Math.sqrt(random);
                System.out.printf("Положительное число: %d Корень положительного числа: %.2f \n", random, sqrt);
            }
        }

    }
}
