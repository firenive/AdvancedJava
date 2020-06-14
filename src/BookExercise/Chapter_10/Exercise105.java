package BookExercise.Chapter_10;

public class Exercise105 {
    /*Напишите класс, который генерирует случайное положительное двузначное число, а затем генерирует три целых
    положительных числа, меньших первого.*/
    public static void main(String[] args) {

        int n = 10 + (int) (Math.random() * 89);

        System.out.println(n);
        for (int i = 0; i < 1000; i++ ) {
            int a = (int) (Math.random() * (n - 1));
            int a1 = 1 + (int) (Math.random() * (n - 1));
            int a2 = 1 + (int) (Math.random() * (n - 1));
            System.out.println(a);
            System.out.println(a1);
            System.out.println(a2);
        }
    }
}
