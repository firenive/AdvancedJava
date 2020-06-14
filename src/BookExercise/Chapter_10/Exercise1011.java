package BookExercise.Chapter_10;

import java.util.Scanner;

public class Exercise1011 {

    public static void main(String[] args) {
        /*Напишите класс, который «выбрасывает три карты» (генерирует три случайных числа - в каких пределах?) и
        определяет, какой из вариантов (недобор, перебор, «очко») реализовался.*/

       int firstCard = 2 + (int) (Math.random() * 10);
       int secondCard = 2 + (int) (Math.random() * 10);
       int thirdCard = 2 + (int) (Math.random() * 10);
       int sum = firstCard + secondCard + thirdCard;

       if (sum > 21) System.out.println(sum + " Перебор");
       else if (sum < 21) System.out.println(sum + " Недобор");
       else System.out.println(sum + " Очко");

    }
}
