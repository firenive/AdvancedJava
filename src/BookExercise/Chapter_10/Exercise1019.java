package BookExercise.Chapter_10;

public class Exercise1019 {
    public static void main(String[] args) {
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

