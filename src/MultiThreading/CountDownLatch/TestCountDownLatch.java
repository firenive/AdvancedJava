package MultiThreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
    /*Иногда требуется, чтобы поток исполнения находился в режиме ожидания до тех пор, пока не наступит одно (или больше)
    событие. Для этих целей в парал­лельном API предоставляется класс CountDownLatch, реализующий самоблокировку с
    обратным отсчетом. Объект этого класса изначально создается с количеством событий, которые должны произойти до того
    момента, как будет снята самоблокировка. Всякий раз, когда происходит событие, значение счетчика уменьшается.
    Как только значение счетчика достигнет нуля, самоблокировка будет снята.*/
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            service.submit(new Processor(count));
        }
        service.shutdown();
        count.await(); // ждем пока счетчик CountDownLatch не достигнет 0. поле этого продолжаем выполнение главного потока
        /* три созданных потока отсчитали 3 секунды и одновременно пронизили пересенную countDown до 0*/
        System.out.println("Latch has been opened. main thread is proceeding ");
    }
}

class Processor implements Runnable {
    private CountDownLatch countDown;
    public Processor( CountDownLatch countDown) {
        this.countDown = countDown;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDown.countDown(); //Дикрементация переменной countDown на  1
    }
}