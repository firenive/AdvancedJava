package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise116 {
    /* Создает и выводит на экран 20 случайных чисел в диапазоне от первого, только что введенного с клавиатуры,
     значения, - до второго значения, также введенного с клавиатуры перед этим, исходя из того, что неизвестно,
        какое из вводимых с клавиатуры значений больше, а какое - меньше..*/
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int first = scan.nextInt();
        int random;
        int second = scan.nextInt();
        for (int i = 0; i <20; i++) {
            if (second > first) random = first + (int) (Math.random()* (second - first + 1));
            else random = second + (int) (Math.random()* (first - second + 1));
            System.out.println(random);
        }
    }
}
