package BookExercise.Chapter_12;

import java.util.Scanner;

public class Exercise124 {
    /*Напишите класс, который принимает с клавиатуры 17 целых чисел и выводит на экран информацию о том, сколько из них
     были больше, чем предыдущее число.*/
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 0, count = 0, tmp;
        for (int i = 0; i < 17; i++) {
            tmp  =x;
            x = scan.nextInt();
            if (x > tmp) count++;
        }
        System.out.println(count-1);
    }
}
