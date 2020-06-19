package BookExercise.Chapter_10;

public class Exercise1016 {
    public static void main(String[] args) {
        /*Напишите класс, который генерирует и выводит на экран два случайных числа из диапазона от 17 до 94.
        Класс   должен проверить, какое из двух чисел, первое или второе, было больше, и вывести на экран соответствующее
         текстовое сообщение. Кроме того, класс должен определить наименьшую цифру из всех фигурирующих в этих числах и
         вывести на экран соответствующее текстовое сообщение.*/
        int n = 17 + (int) (Math.random() * 78);
        int n2 = 17 + (int) (Math.random() * 78);
        System.out.println(n);
        System.out.println(n2);
        int a1 = n / 10;
        int a2 = n % 10;
        System.out.println(a1 + "   " + a2);
        int b1 = n2 / 10;
        int b2 = n2 % 10;
        System.out.println(b1 + "   " + b2);
        if (n > n2) System.out.println("Первое число больше");
        else if (n < n2) System.out.println("Второе число больше");
        int[] numbers = {a1, a2, b1, b2};
        int min = a1;
        for (int i = 1; i < numbers.length; i++ ) {
            if (numbers[i] < min ) min = numbers[i];
        }
        System.out.println("Минимальное число" + min);


    }
}

