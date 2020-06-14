package BookExercise.Chapter_10;

public class Exercise106 {
    /* Напишите класс, который генерирует случайное положительное двузначное число, а затем генерирует три целых
    двузначных числа, не меньших первого.*/
    public static void main(String[] args) {

        int n = 10 + (int) (Math.random() * 89);

        System.out.println(n);
        for (int i = 0; i < 1000; i++ ) {
            int a = n + (int) (Math.random() * (99 - n));
            int a1 = n + (int) (Math.random() * (99 - n));
            int a2 = n + (int) (Math.random() * (99 - n));
            System.out.println(a);
            System.out.println(a1);
            System.out.println(a2);
        }
    }
}
