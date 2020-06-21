package BookExercise.Chapter_10;

public class Exercise1020 {
    public static void main(String[] args) {
        /* Напишите класс, который генерирует и выводит на экран сначала случайное положительное однозначное число
        (цифру), а затем - случайное целое трехзначное. Класс должен определить разницу между сгенерированной цифрой и
        наибольшей цифрой сгенерированного случайного трехзначного числа.*/
        int x = (int) (Math.random() * 10);

        int n = 99 + (int) (Math.random() * 901);
        System.out.println(n);
        int a1 = n / 100;
        int a2 = n % 100 / 10;
        int a3 = n % 10;
        int[] numbers = {a1, a2, a3};
        int max = a1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i];
        }
        System.out.println("Разница между " + x + " и " + max + " составляет " + (x - max));



    }
}
