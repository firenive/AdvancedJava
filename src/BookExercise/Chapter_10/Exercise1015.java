package BookExercise.Chapter_10;

public class Exercise1015 {
    public static void main(String[] args) {
        /*Напишите класс, который генерирует и выводит на экран случайное число из диапазона от 250 до 746, а затем в
        отдельных строках, - наименьшую и наибольшую из цифр этого числа. Класс также должен проверить, были ли в
        генерированном числе одинаковые цифры, и вывести на экран соответствующее текстовое сообщение.*/
        int n = 250 + (int) (Math.random() * 497);
        System.out.println(n);
        int a1 = n / 100;
        int a2 = n % 100 / 10;
        int a3 = n % 10;
        int[] numbers = {a1, a2, a3};
        int max = a1;
        int min = a1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i];
            if (numbers[i] < min) min = numbers[i];
        }
        System.out.println("Наибольшее: " + max);
        System.out.println("Наименьшее: " + min);
        if (a1 == a2 || a1 == a3 || a2 == a3) System.out.println("Были одинаковые числа");

    }
}

