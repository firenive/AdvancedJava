package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_922 {
    static Scanner scan = new Scanner(System.in);
    /* В кассе имеются купюры достоинством 100, 50 и 10 рублей. Напишите класс, который принимает с клавиатуры целое
    число, выражающее сумму в рублях, которую надо выплатить. Класс должен определить, каким минимальным набором купюр можно
    выдать введенную с клавиатуры сумму и какими купюрами. Если нет возможности выплатить указанную сумму, на экран следует
    вывести соответствующее текстовое сообщение.*/
    public static void main(String[] args) {
        int rub = scan.nextInt();
        int a100, a50, a10;

        if (rub % 10 == 0) {
             a100 = rub / 100;
             rub %= 100;
             a50 = rub / 50;
             rub %=50;
             a10 = rub / 10;
            System.out.println("Сто рублей: " + a100 + " Пятьдесят рублей: " + a50 + " Десять рублей: " + a10);
        }
        else System.out.println("Сумму выплатить невозможно");


    }
}
