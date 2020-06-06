package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_930 {
    static Scanner scan = new Scanner(System.in);

    /* Напишите класс, который принимает с клавиатуры трехзначное число и проверяет, на какое число из составляющих
    его цифр оно делится (без остатка). Следует учесть возможность того, что одной из цифр в проверяемом числе может
    быть и О.*/
    public static void main(String[] args) {
        int x = scan.nextInt();
        int n1 = x / 100;
        int n2 = x % 100 / 10;
        int n3 = x % 10;

        if (n1 != 0 && x % n1 == 0) System.out.print("На первое число; ");
        if (n2 != 0 && x % n2 == 0) System.out.print("На второе число; ");
        if (n3 != 0 && x % n3 == 0) System.out.print("На третье число. ");
        else System.out.println("Число не делится нацело на составляющие цифры");


    }
}
