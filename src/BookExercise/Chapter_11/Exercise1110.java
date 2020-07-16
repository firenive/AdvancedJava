package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise1110 {
    /* Напишите класс, который выводит на экран (в одну строку) 19 случайных чисел из дr1апазона «однозначные числа».
     Каждое значение, равное О, следует вывести на экран «В окружении» (вплотную к числу, перед ним и после него)
     символов«%» (процент).*/
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 0; i <19; i++) {
            int random = -9 + (int) (Math.random()* 19);
            if (random  == 0) System.out.print(" %" + random+"% ");
            else System.out.print(" " +  random + " ");
        }
    }
}
