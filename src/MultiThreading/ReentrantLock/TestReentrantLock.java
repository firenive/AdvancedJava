package MultiThreading.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    public static void main(String[] args) {
        /*Класс ReentrantLock предназначен для синхронизации потоков в Java. В отличии от synchronized позволяет избежать
        * взаимной блокировки (Deadlock) */
        Task task = new Task();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();
        task.showCounter();
    }
}
class Task {
    private int counter;
    private Lock lock = new ReentrantLock();
    /* Класс ReentrantLock реализует интерфейс Lock пакета java.util.concurrent.lock. */
    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        /* Если какой либо поток успел вызвать метод lock() на одном объекте все остальные потоки ждут пока
         не будет вызван метод unlock(), разблокирующий монитор объекта. Метод lock() может вызыватья потоком сколько угодно
         раз. Но если поток 5 раз вызвал метод lock() для передачи*/
        increment();
        lock.unlock();
    }
    private void increment() {
        for (int i = 0; i< 10000; i++) counter++;
    }
    public void showCounter() {
        System.out.println(counter);
    }
}
