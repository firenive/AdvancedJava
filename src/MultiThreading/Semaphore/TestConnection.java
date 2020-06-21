package MultiThreading.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestConnection {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(200);
        Connection connect = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // connect.doWork();
                        connect.doWorkWithSemaphore();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }
}
class Connection { // паттерн Singleton. Гарантирует что объект класса Connection будет создан только 1 раз
    private static Connection connection = new Connection();
    private int conCounter;
    private Semaphore sem = new Semaphore(10);
    private Connection() { // приватный конструктор не даст создать объекты класса

    }
    public static Connection getConnection() {
        return connection;
    }
    public void doWorkWithSemaphore() throws InterruptedException {
        sem.acquire();
        try {
            doWork();
        } finally {
            sem.release(); //  в случае использования try/catch разрешение всегда должно освобождаться в блоке finally
        }
    }
    public void doWork() throws InterruptedException { // создаем соединение (увеличиваем переменную. После выполнения рыботы
        synchronized (this) { // закрываем соединение (Уменьшая счетчик открытых соединений
            conCounter++;
            System.out.println(conCounter);
        }
        Thread.sleep(5000);
        synchronized (this) {
            conCounter--;
            System.out.println(conCounter);
        }
    }
}
