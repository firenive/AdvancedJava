package BookExercise.Chapter_10;

import java.util.Scanner;

public class Exercise104 {
    public static void main(String[] args) {
        // Напишите класс, который принимает с клавиатуры целое положительное число, а затем генерирует
        // три целых положительных числа, меньших первого.
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int a = (int) (Math.random() * n-1);
        int b = (int) (Math.random() * n-1);
        int c = (int) (Math.random() * n-1);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
