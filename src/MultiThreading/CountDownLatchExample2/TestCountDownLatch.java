package MultiThreading.CountDownLatchExample2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
    /* Теперь отчитываем count в главном потоке.При этом ждем выполнения по задачам в трех потоках выполняющих задания
    * в методе run() */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            service.submit(new Processor(i, count));
        }
        service.shutdown();
        for (int i = 0; i <3; i++) { // отсчет переменной до 0. Как только цикл итерируется 3 раза выполнение кода в методе
            // run() продолжится дальше
            Thread.sleep(1000);
            count.countDown();
        }
        System.out.println("Latch has been opened. main thread is proceeding ");
    }
}

class Processor implements Runnable {
    private CountDownLatch countDown;
    private int id;
    public Processor(int id,  CountDownLatch countDown) {
        this.id = id; // назначаем id каждому потоку
        this.countDown = countDown;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            countDown.await(); // три аотока ждут пока countDownLatch не станет равна 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with id '" + id + "' proceeded");
    }
}