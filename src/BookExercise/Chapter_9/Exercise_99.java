package BookExercise.Chapter_9;

import java.util.Scanner;

public class Exercise_99 {
    static Scanner scan = new Scanner(System.in);

    /*Напишите класс, который принимает с клавиатуры коэффициенты а и Ь линейного уравнения (уравнения первой степени
     - ах+Ь=О) и решает его, - то есть выводит на экран или корень (корни) уравнения, или соответствующее  сообщение.*/
    public static void main(String[] args) {
        double a = scan.nextInt();
        double b = scan.nextInt();
        decison(a, b);

    }

    public static void decison(double a, double b) {
        if (a == 0 & b != 0) System.out.println("Уравление не имеет корней");
        else if (a == 0 && b == 0) System.out.println("Уравнение имеет бесконечное множество решений");
        else {
            double x = -(b / a);
            System.out.println(x);
        }
    }
}
