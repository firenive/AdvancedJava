package BookExercise.Chapter_10;

public class Exercise101 {
    public static void main(String[] args) {
        int n = 0;
        // Напишите класс, который генерирует и выводит на экран случайное
        // целое чисел из диапазона положительных двузначных чисел.
        for (int i = 0; i < 99; i++) {
            n = 10 + (int) (Math.random() * 89);
            System.out.println(n);
        }
    }
}
