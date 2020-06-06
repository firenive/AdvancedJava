package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_921 {
    static Scanner scan = new Scanner(System.in);
    /* принимает с клавиатуры временной интервал, выраженный в секундах, и выводит на экран тот же интервал, но
    выраженный в часах, минутах и секундах. Если промежуток времени превышает сутки, то надо не производить
    пересчет, а просто вывести на экран текстовое сообщение Расчет не производится.*/
    public static void main(String[] args) {
        int sec = scan.nextInt();
        if (sec < 86400) {
            int hour = sec / 3600;
            int min = sec % 3600 / 60;
            sec = sec % 60;
            System.out.println(hour + " час(ов) " + min + " минут(ы) " + sec + " секунд(ы)");
        } else System.out.println("Расчет не производился");

    }
}
