package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_920 {
    static Scanner scan = new Scanner(System.in);
    /* принимает с клавиатуры промежуток времени, выраженный в секундах, и выводит на экран его же,
    но выраженный в минутах и секундах.*/
    public static void main(String[] args) {
        int sec = scan.nextInt();
        int min = sec / 60;
        sec = sec % 60;
        System.out.println(min + " минут(ы) " + sec + " секунд(ы)");

    }
}
