package BookExercise.Chapter_10;

import org.w3c.dom.ls.LSOutput;

public class Exercise102 {
    /*Напишите класс, который генерирует и выводит на экран 2 случайных целых числа из диапазона «однозначные» (включая
     и положительные, и отрицательные). После этого в отдельной строке класс должен вывести наибольшее из
э   тих двух чисел - с соответствующим текстовым сообщением.*/
    static double sign = (Math.random() - Math.random());
    static int result = 0;

    public static void main(String[] args) {
        if (sign < 0) result = (int) Math.floor(sign);
        else result = (int) Math.ceil(sign);
        int a = (int) ((Math.random() * 10) * result);
        int b = (int) ((Math.random() * 10) * result);

        if (a > b) System.out.println(a);
        else System.out.println(b);

        System.out.println(randomNumber());

    }
    public static int randomNumber() {
        int a, down = -9, up = 9;
        a = down + (int) ((up - down + 1) * Math.random());
        return a;
    }
}
