package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_97 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        if (n1 + n2 < 180) {
            if (n1 < 90 & n2 < 90) System.out.println("Остроугольный");
            if (n1 == 90 || n2 == 90) System.out.println("Прямоугольный");
            if (n1 > 90 || n2 > 90) System.out.println("Тупоугольный");
            if (n1 == n2) System.out.println("Равнобедренный, если введенные углы являются углами при основании");
            if (n1 == 60 && n2 == 60) System.out.println("Треугольник равносторонний");
        }
        else if (n1 + n2 > 180) System.out.println("Ошибочные данные");

    }
}
