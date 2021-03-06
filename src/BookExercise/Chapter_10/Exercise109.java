package BookExercise.Chapter_10;

import java.util.Scanner;

public class Exercise109 {
    /* Напишите класс, который принимает с клавиатуры целое число и затем генерирует («придумывает>>) случайное число из
     следующего диапазона:
    • «центром диапазона» является введенное с клавиатуры число;
    • количество чисел в диапазоне равно 11.
    Класс должен определять, «угадал» ли компьютер введенное число и выводить на экран одно из сообщений (в зависимости
    от соотношения введенного и «придуманного» чисел):
    • угадал - если числа совпали;
    • слишком большое - если «придуманное» компьютером число
    больше введенного с клавиатуры;
    • слишком маленькое - если «придуманное» компьютером число
    меньше введенного с клавиатуры.*/
    public static void main(String[] args) {


        int middle = (int) (Math.random() * 99);
        System.out.println(middle);

        for (int i = 0; i < 100; i++) {
            int random = (middle - 5) + (int) (Math.random() * (11));
            if (random == middle) System.out.println(random + " Угадал");
            else if(random > middle) System.out.println(random + " Слишком большое");
            else  System.out.println(random + " слишком маленькое");
        }
    }
}
