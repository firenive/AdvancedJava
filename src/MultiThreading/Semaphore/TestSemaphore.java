package MultiThreading.Semaphore;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public static void main(String[] args) throws InterruptedException {
        /*Семафор — это средство для синхронизации доступа к какому-то ресурсу. Его особенность заключается в том, что
         при создании механизма синхронизации он использует счетчик. Счетчик передается параметром в конструктор при создании
         объекта. Счетчик обозначает количество разрешений для потоков (сколько потоков одновременно может работать с объектом) */
        Semaphore sem = new Semaphore(3);

        sem.acquire();
        sem.acquire();
        sem.acquire();
        System.out.println("All permits have been acquired");
        sem.acquire(); // Все доступные разрешения были израсходованы. Выполнения кода остановится здесь пока не будет
        // выполнен хотя бы один release()
        System.out.println("Can't reached here");


        /*Методы acquire() и release() класса Semaphore управляют его счетчиком разрешений. Метод acquire() запрашивает
        разрешение на доступ к ресурсу у семафора. Если счетчик > 0, разрешение предоставляется, а счетчик уменьшается на 1.

        Метод release() «освобождает» выданное ранее разрешение и возвращает его в счетчик (увеличивает счетчик разрешений
        семафора на 1).*/

        System.out.println(sem.availablePermits()); // возвращает количество свободных разрешений

    }
}
