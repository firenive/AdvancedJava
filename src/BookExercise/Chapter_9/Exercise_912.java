package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_912 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scan.nextInt();
        int n1 = a / 100;
        int n2 = a % 100 / 10;
        int n3 = a % 10;
        if (n1 < n2 && n2 < n3) System.out.println("Число поднимающееся");
        else System.out.println("Число не поднимающееся");
    }
}
