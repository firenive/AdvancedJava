package MultiThreading.Introduction;

public class IntroductionThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start(); // для старта нового потока используется метод start()
        /* метод run() для старта потока не нужно вызывать у объекта MyThread. Использовать start()
         start() запускает новый поток и выполняет код из метода run в новом потоке после запуска потока поток main
         продожлает выполняться и выводит надпись main потоки в Java по умолчанию не синхронизированы */

        Thread.sleep(2000); // приостанавливает поток на указанное время в ms

        System.out.println("main");
        MyThread myThread1 = new MyThread();
        myThread1.start(); // запуск еще одного потока

        Thread thread = new Thread(new Runner()); // создаемм объект класса Thread. В качестве параметра передаем класс
        // реализующий интерфейс Runnable
        thread.start(); // запуск потока
        System.out.println("End main"); // Поток main закончился, но другие запущенные потоки могут продолжать выполнение
        // программы. Программа завершится как только все ее потоки завершат свое исполнение
    }
}
class MyThread extends Thread { // первый способ создания потока

    @Override // действие будет выполняться в отдельном потоке
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Thread" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class Runner implements Runnable { // второй способ создания потока с помощью реализации интерфейса Runnable
 // препочтительнее первого
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Thread" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
