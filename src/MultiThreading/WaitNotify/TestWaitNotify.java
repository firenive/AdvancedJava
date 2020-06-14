package MultiThreading.WaitNotify;

import java.util.Scanner;

public class TestWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        /* wait(), notify() определены у класса Object и как следствие у любого объекта в Java. Методы предназначены для
         синхронизации объектов */
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
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

class WaitAndNotify {

    public void produce() throws InterruptedException {
        synchronized (this) {
            /*wait() имеет смысл вызывать только в пределах синхронизованного блока на том объекте, который передается в
            блок synchronized(). Когда вызывается метод wait() происходит следующее:
            1) отдаем intrinsic lock (то есть выходим из synchronized блока). Другие потоки могут работать с передаваемым
               объектом
            2) Ждем пока будет вызван метод notify() на этом объекте. Важно чтобы wait() notify()  */
            System.out.println("Producer thread started");
            wait(); // останавливаем здесь пока с помощью метода notify() не вернут фокус этому потоку
            // wait(1000); Метод определен с параметром timeout в ms. Ждем указанное время пока где-нибудь вызовется notify()
            // Если за это время notify не будет вызван и монитор объекта будет свободен продолжаем дльнейшее выполнение потока
            System.out.println("Producer thread resumed");
        }
    }
    Object lock = new Object();
    public void produce2() throws InterruptedException {
        synchronized (lock) {
            /* Если же в synchronized блок передввется элемент отличный от this при вызове метода wait(), notify()
            необходимо четко прописать из под каких объектов вызываются методы */
            lock.wait(); // Правильный вызов из под объекта lock
            wait(); // Неправильный вызов, так как wait по умолчанию вызывается под this

            lock.notify(); // Правильный вызов
            notify(); // неправильный вызов
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scan = new Scanner(System.in);
        synchronized (this) {
            System.out.println("Waiting for return key");
            scan.nextLine();
            notify(); // пробуждает только один поток ( передает управление потоку, в котором вызван метод wait())
           // notifyAll(); // пробуждает все потоки в которых вызван метод wait()

            /* при этом notify() не передает монитор объекта обратно в поток, где был вызван wait() передача произойдет
            лишь после выполнения всего кода после notify(). К примеру если после notify() вызвать Thread.sleep(5000)
             передача потока произойдет только после 5 секунд*/
            Thread.sleep(5000);
        }

    }
}
