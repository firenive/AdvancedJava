package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise118 {
    /* Создает и выводит на экран 20 случайных чисел в диапазоне от первого, только что введенного с клавиатуры,
     значения, - до второго значения, также введенного с клавиатуры перед этим, исходя из того, что неизвестно,
        какое из вводимых с клавиатуры значений больше, а какое - меньше..*/
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 0; i <15; i++) {
            int random = -20 + (int) (Math.random()* 56);
            if (random <0) System.out.println(random+"?");
            else System.out.println(random);
        }
    }
}
