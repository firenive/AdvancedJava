package MultiThreading.Volatile;

import java.util.Scanner;

public class MainVolatile {
    public static void main(String[] args) {
        /* Ключевое слово volatile необходимо для синхронизации данных между потокаи. Например одна переменная используется
        *  сразу несколькими потоками. Один поток пишет в переменную, а еще один или несколько потоков читают из этой
        *  переменной  */
        ViolateThread thread = new ViolateThread();
        thread.start();
        Scanner scan = new Scanner(System.in);
        scan.nextLine(); // ждет ввода строки. только после ввода выполнение кода продолжится и метод shutdown() завершит цикл
        /* Для того чтобы это отрабатывало 100% и метод shutdown() завершал цикл необходимо синхронизировать переменную
        * running между потоками. для этого используем ключевое слово volatile */

        thread.shutdown();
        /*В компьютерной архитектуре , когерентность кэша является единообразием общих данных ресурсов , которая
        заканчивается храниться в нескольких локальных кэшах . Когда клиенты в системе поддержания кэшей общего
        ресурса памяти, могут возникнуть проблемы с некогерентными данными, что особенно в случае с процессорами в
        многопроцессорной системе.
        https://ru.qwe.wiki/wiki/Cache_coherence*/
    }
}
class ViolateThread extends Thread{
    private volatile boolean running = true;
    /* При использовании ключевого слова volatile переменная не кэшируется для всех ядер процессора на которых запущены
    * потоки программы. Значение переменной хранится в общей памяти, что позволяет устранить проблему когерентности кэша */

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown() {
        this.running = false;
    }
}
