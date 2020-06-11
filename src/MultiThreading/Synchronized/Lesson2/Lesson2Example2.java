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

    /*Для одновременной работы двух потоков с синхронизованными методами  addToList1() и addToList2() создадим два
    дополнителньых объекта. Хорошим тоном является присваивание имени объекту с использованием слово lock, что показывает
    что эти два объекта созданы именно для синхронизации. Объект может быть любого класса (необязательно Object) например
    ArrayList. Убираем слово synchronized из сигнатуры методов add и добавляем synchronized блок, в котором указываем
    объект на котором будет происходить синхронизация. После этого значительно возрастет скорость выполнения методов.
    При простой синхронизации методов под объектом worker время выполнения было ~ 6200 ms. После того как прописали
    synchronized блоки под отдельными объектами время выполнения программы ~ 3600 ms */

    Object lock1 = new Object();
    Object lock2 = new Object();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public  void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100)); // Добавляет в список случайное число в промежтке от 0 до 99
        }
    }


    public void addToList2() {
        synchronized (lock2) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100)); // Добавляет в список случайное число в промежтке от 0 до 99
        }
    }


    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {

        long before = System.currentTimeMillis(); // замеряем время выполнения
        /* Метод work() отрабатывает примерно за 3200 ms так как 20000 ms занимает ожидание, прописанное в каждом методе
        обновления. Для ускорения скорости работы попробуем распараллить выполнения метода на отдельные потоки. Запустим
        метод work() дважды на двух потоках. Время выполнения будет составлять ~ 3700 секунда, несмотря на то что количество
        добавляемых элементов увеличилось вдвое (с 2000 до 4000). Но теперь есть проблема несинхронизированности методов
        addToList1() и addToList2(). Из-за этого в листах находится не по 2000 элементов. а меньше. Например 1952.
        Для решения проблемы синхронизируем потоки. При этом время выполнения метода увеличится примерно до 6200 ms
        Время выполнения увеличилось, так как оба метода addToList1() и addToList2() запущены из под объекта worker
        При этом потоки вынуждены поочередно передавать монитор этого объекта друг другу, из-за чего время выполнения
        Увеличивается в два раза Это не очень эффективно. так как методы работают над наполнением элементами каждый своего
        листа. Можно увеличить скорость работы, добившись чтобы потоки работали одновременно запустив синхронизация для
        отдельных объектов класса */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();
        System.out.println("Program execution time: " + (after - before));
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }
}
