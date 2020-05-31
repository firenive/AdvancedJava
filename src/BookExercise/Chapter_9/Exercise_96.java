package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_96 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();

        if ((n1 + n2 > n3) && (n1 + n3 > n2) && (n3 + n2 > n1)) {
            System.out.println("Введенные числа могут являться длиннами сторон треугольника");
        } else System.out.println("Введенные числа не являются длиннами сторон треугольника");

    }
}
