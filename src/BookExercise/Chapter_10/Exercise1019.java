package BookExercise.Chapter_10;

public class Exercise1019 {
    public static void main(String[] args) {
        /*Напишите класс, который генерирует и выводит на экран последовательность из 5 случайных целых чисел из диапазона
         от -50 до 50. Класс должен определить, сколько раз в этой последовательности менялся знак.
         Например: в последовательности 1, -34, 8, 14, -5 знак меняется 3 раза.*/
        int prev = 0, n = 0;
        int dif = 0;
        for (int i = 0; i < 10; i++) {
            if (i >= 1) {
                prev = n;
                System.out.println("Prev " + prev);
            }
             n = -10 + (int) (Math.random() * 21);
            if ((prev > 0 && n <= 0)) dif++;
            else if (prev < 0 && n >= 0) dif++;
            System.out.println(n);
        }
        System.out.println("Знак менялся " + dif + " раз");
    }
}

