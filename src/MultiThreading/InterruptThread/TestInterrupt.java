package MultiThreading.InterruptThread;

import java.util.Random;

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        /* механизм прерывания заключается в том чтобы из одного потока прервать другой поток. Для этого сществует метод
        * interrupt() и stop(). Stop является устаревшим методом и его не рекомендуется использовать так как в результате
        * грубого прерывания потока теряются все данные, полученные в результате работы потока. Interrupt является более
        * мягким методом. он не сразу останавливает поток,а дает ему сообщение что поток хотят прекратить. Возможность
        * получения сообщения потоком можно обработать в методе run методом isInterrupted(). В нашем примере создадим доп
        * условие. Если сообщение о прерывании было получено выходим из цикла*/
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    if (Thread.currentThread().isInterrupted()) { // выходим из цикла, если получено сообщение о прерывании
                        System.out.println("Thread was interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble()); // выполнение вычислений будет происходить очень долго
                   }
            }
        });
        System.out.println("Starting thread");
        thread1.start();
        Thread.sleep(10_000); // Посылаем сообщение о прерывании через 10 секунд
        thread1.interrupt();
        thread1.join();
        System.out.println("Thread has finished");
    }
}
