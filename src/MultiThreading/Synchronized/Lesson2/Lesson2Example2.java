package MultiThreading.Synchronized.Lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson2Example2 {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.main();
    }
}

class Worker {
    Random random = new Random(); // Класс по созданию случайного числа. Аналогичен Math.random()
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100)); // Добавляет в список случайное число в промежтке от 0 до 99
    }


    public void addToList2() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100)); // Добавляет в список случайное число в промежтке от 0 до 99
    }


    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {

        long before = System.currentTimeMillis();
        work();
        long after = System.currentTimeMillis();
        System.out.println("Program execution time: " + (after - before));
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
    }
}
