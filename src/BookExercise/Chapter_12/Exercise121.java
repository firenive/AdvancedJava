package BookExercise.Chapter_12;

import java.util.Scanner;

public class Exercise121 {
    /*Напишите класс, который принимает с клавиатуры 10 целых чисел и выводит на экран информацию о том, сколько из них
     были положительными.*/
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int x, count = 0;
        for (int i = 0; i < 10; i++) {
            x = scan.nextInt();
            if (x >0) count++;
        }
        System.out.println(count);
    }
}
