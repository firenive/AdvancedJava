package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1138 {
    static Scanner scan = new Scanner(System.in);
    /*Напишите класс, который принимает с клавиатуры целое число, а затем генерирует 15 случайных чисел из диапазона
    положительных трехзначных чисел. Для тех сгенерированных чисел, которые делятся на введенное с клавиатуры значение,
    следует вывести на экран округленный в большую сторону квадратный корень из первой цифры (число сотен), для остальных
     - округленный в меньшую сторону квадратный корень из второй цифры (число десятков).*/
    public static void main(String[] args) {
        int random, n1, n2;
        double sqrt1, sqrt2;
        int x = scan.nextInt();
        for (int i = 0; i < 15; i++) {
            random = 100 + (int) (Math.random() *900);
            n1 = random / 100;
            n2 = random % 100 / 10;
            sqrt1 = Math.ceil(Math.sqrt(n1));
            sqrt2 = Math.floor(Math.sqrt(n2));
            if (random % x == 0) {
                System.out.println(" Число1 " + random + " Корень сотни " + sqrt1 );
            }
            else  System.out.println(" Число2 " + random + " Корень десятки " + sqrt2 );

        }

    }
}
