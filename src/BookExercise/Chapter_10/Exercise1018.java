package BookExercise.Chapter_10;

import java.util.Arrays;

public class Exercise1018 {
    public static void main(String[] args) {
        /* Напишите класс, который генерирует и выводит на экран 3 случайных целых положительных трехзначных числа.
        Затем класс должен определить разницу между наибольшим и наименьшим из сгенерированных чисел и вывести ее на
        экран вместе с соответствующим текстовым сообщением.*/
        int n1 = 99 + (int) (Math.random() * 901);
        int n2 = 99 + (int) (Math.random() * 901);
        int n3 = 99 + (int) (Math.random() * 901);
        int[] numbers = {n1, n2, n3};

        int min = n1;
        int max = n1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("Минимальное значение " + min);
        System.out.println("Максимальное значение " + max);
        System.out.println("Разница " + (max - min));

    }
}

