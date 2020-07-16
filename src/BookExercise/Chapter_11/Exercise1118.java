package BookExercise.Chapter_11;

public class Exercise1118 {
    public static void main(String[] args) {
        /*Напишите КJ1асс, который выводит на экран в строку положительные четырехзначные числа, заканчивающиеся на 00
        (в убывающем порядке). Числа должны отделяться друг от друга знаком «пробел». */
        int n1, n2;
        for (int i = 9999; i >999; i--) {
            n1 = i % 100 / 10;
            n2 = i % 10;
            if (n1 == 0 && n2 ==0) System.out.println(i + " ");
        }

    }
}
