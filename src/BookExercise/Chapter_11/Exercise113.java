package BookExercise.Chapter_11;

import java.util.Scanner;

public class Exercise113 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <6; i++) {
            int k = scan.nextInt();
            if(k > 100) sum = sum +k;
        }
        System.out.println(sum);
    }
}
