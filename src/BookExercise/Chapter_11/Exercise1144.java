package BookExercise.Chapter_11;

public class Exercise1144 {
    /*Напишите класс, который выводит на экран (в строку с пробелами) все двузначные целые положительные числа, в которых
     и цифра единиц, и цифра десятков делятся на три с одинаковым остатком.*/
    public static void main(String[] args) {
        double remainder1;
        double remainder2;
        for (int i = 10; i<=99; i++) {
            int n1 = i / 10;
            int n2 = i % 10;
            remainder1 = (double) n1 % 3;
            remainder2 =  (double) n2 % 3;
            if (remainder1 == remainder2) System.out.println(i);
        }

    }

}

