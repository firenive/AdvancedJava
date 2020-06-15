package MultiThreading.ProducerConsumer.Lesson2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class ProducerConsumerMain {
    public static void main(String[] args) throws InterruptedException {
        /* Реализация паттерна ProducerConsumer без использования очереди типа ArrayBlockingQueue. В качестве очереди будет выступать
        * LinkedList, для которого будет установлен лимит элементов. Методы produce и consumer бдут работать с отдельныи потоками.
        * Передача управления потокам будет осуществляться с помощью методов wait() notify()*/
        ProducerConsumer pc = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList(); // обычная очередь не потокобезопасная
    private final int LIMIT = 10; // лимит устанавливаемый для LinkedList
    private final Object lock = new Object(); // синхронизация будет происходить на этом объекте. Объекты на которых
    // происходит синхронизация должны быть константами

    public void produce() throws InterruptedException {
        Random random = new Random();
        while(true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) lock.wait();
                /* цикл while используется для того чтобы проверить условие  по достигнотуму лимиту два раза. первый раз
                * проверяется как только дойтет до указанной строчки кода. Второй раз проверяетсяпосле того как поток
                * возобновляется с wait(). Тогда цикл уходит на проверку условия и делает ее повторно */

                queue.add(random.nextInt(99)); // add() и offer() не являютя потоко-безопасными методами
                lock.notify();// Как только закидываем новый элемент в очередь нужно уведомить consume, о том что есть
                // элемент, который можно забрать. Чаще всего notify() вызывается в конце синхронизированного блока
            }

        }
    }
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) { // Ждем метода produce() в том случае, если в очереди нет элементов
                    lock.wait();
                }
                System.out.println(queue.poll());
                System.out.println("Размер очереди = " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }

    }
}
