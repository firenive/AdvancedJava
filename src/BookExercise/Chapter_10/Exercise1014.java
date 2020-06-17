package BookExercise.Chapter_10;

public class Exercise1014 {
    /*Напишите класс, который создает и выводит на экран 5 случайных целых чисел, заканчивающихся на ноль, и принадлежащих
     к диапазону двузначных чисел.*/
    public static void main(String[] args) {
        int count = 0;
        while(count < 5) {
            int n = 10 + (int) (Math.random()* 89);
            if (n % 10 == 0) {
                System.out.println(n);
                count++;

            }
        }
        System.out.println("--------------------");
        generation();
    }
    // 2 способ. Является предпочтительным, так как не генерирует лишние числа
    private static void generation() {
        int first;
        for (int i = 0; i < 5; i++) {
            first = 10* (int) ((Math.random() * 9) +1);
            System.out.println(first);
        }
    }
}
