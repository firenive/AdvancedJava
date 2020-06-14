package BookExercise.Chapter_10;

public class Exercise107 {
    /* Напишите класс, который генерирует два случайных положительных двузначных числа, обозначающих границы некоторого
    интервала, а затем генерирует три целых положительных числа внутри данного интервала.*/
    public static void main(String[] args) {

        int upperLimit = 10 + (int) (Math.random() * 89);
        int lowerLimit = 10 + (int) (Math.random() * 89);

        System.out.println(lowerLimit);
        System.out.println(upperLimit);
        for (int i = 0; i < 1000; i++ ) {
            int a = lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit));
            int a1 = lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit));
            int a2 = lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit));
            System.out.println(a);
            System.out.println(a1);
            System.out.println(a2);
        }
    }
}
