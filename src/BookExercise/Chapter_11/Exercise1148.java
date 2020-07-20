package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1148 {
    /* сначала принимает с клавиатуры целое положительное двузначноечисло;
    • затем выводит на экран (в строку с пробелами) трехзначные целые положительные числа, в которых предварительно введенное
    двузначное число является «внутренней» частью (как, например, 23 для 123 или 623).*/
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int x = scan.nextInt();
        int n1, n2;
        for (int i = 100; i <=999; i++) {
            n1 = i / 10;
            n2 = i %100;
            if (x == n1 || x == n2) System.out.println(i);

        }

    }

}

