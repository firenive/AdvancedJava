package BookExercise.Chapter_11;

public class Exercise1120 {
    public static void main(String[] args) {
        /* Напишите класс, который выводит на экран в строку положительные трехзначные числа, делящиеся на 80 с остатком
        45 (в возрастающем порядке).*/
        int n1, n2;
        for (int i = 100; i < 999; i++) {
            if (i % 80 == 45)
                System.out.println(i + " ");
        }

    }
}
