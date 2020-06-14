package MultiThreading.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduceTest {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {

        /* Создадим объект класса ArrayBlockingQueue сослав его на интерфейс BlockingQueue, Данная очередь потоко-безопасная
         * и у нее есть ограничение по размеру. Реализуем на ее основании паттерн producer-consumer. Метод produce
         * будет класть случайные числа в очередь. метод consumer будет их забирать. Под них реализуем два потока. один
         * будет забирать элементы, второй класть их в очередь. Метод, который кладет элементы в очередь отрабатывает
         * юыстрее так как нет искуственных ограничений. Каждый раз прежде чем положить элементы в очередь он проверяет
         * заполненность очереди и ждет пока метод consumer заберет из нее элемент. как только это происходит кладется
         * новый элемент */

        Thread produceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer();
            }
        });
        produceThread.start();
        consumerThread.start();

        produceThread.join();
        consumerThread.join();
    }

    private static void produce() { // один поток пишет данные, второй поток будет их забирать
        Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt(100)); // кладем элементы. ждет если очередь заполнена. capacity queue = 10;
            } catch (InterruptedException e) { // выбрасывает исключение
                e.printStackTrace();
            }
        }
    }

    private static void consumer() {
        Random rand = new Random();
        while (true) {
            try {
                Thread.sleep(100);
                if (rand.nextInt(10) == 5) {
                    System.out.println(queue.take()); //  забираем элементы. метод take ждет пока в ArrayBlockingQueue
                    // не появятся элементы
                    System.out.println("Queue size: " + queue.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
