package MultiThreading.Semaphore;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    // https://javarush.ru/groups/posts/2174-v-chem-raznica-mezhdu-mjhjuteksom-monitorom-i-semaforom
    /*Представь, что у нас есть 5 философов, которым нужно пообедать. При этом у нас есть один стол, и одновременно
     находиться за ним могут не более двух человек. Наша задача — накормить всех философов. Никто из них не должен
     остаться голодным, и при этом они не должны «заблокировать» друг друга при попытке сесть за стол (мы должны избежать
      deadlock).*/
    private Semaphore sem;
    // поел ли философ
    private boolean full = false;
    private String name;
    public Philosopher(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            // Если философ еще не ел
            if (!full) {
                // запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println(name + " садится за стол");

                // философ ест
                sleep(1000);
                full = true;
                System.out.println(name + " поел. Он выходит из-за стола");
                sem.release();

                // философ ушел освободив место другим
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
