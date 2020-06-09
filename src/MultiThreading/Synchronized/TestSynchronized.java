package MultiThreading.Synchronized;

public class TestSynchronized {
    private int counter;

    public static void main(String[] args) throws InterruptedException {

        /* Ключевое слово synchronized может использоваться только для методов. реализуем синхронизованный метод increment()
         * который исправит проблемму несогласованности операций по записи данных между потоками. synchronized устанавливает
         * правило согласно которому только один поток имеет доступ к телу метода в данный момент времени. Исключается ситуация
         * при которой два и более потоков одновременно выполняют тело  синхронизированного метода */
        TestSynchronized test = new TestSynchronized();
        test.doWork();
        /*Синхронизация происходит на определенном объекте (Как например выше создан объект test). У всех объектов в
        Java есть монитор. Монитор в один момент времени может принадлежать только одному потоку */
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment(); // в методе указано ключевое слово synchronized
                    System.out.println(counter + " Thread1");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                    System.out.println(counter + "  Thread2");
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Result:" + counter);
        /* Result теперь всегда равен 20000. Во первых мы выводим переменную после завершения всех потоков, которые
         изменяют ее значение. Во вторых операция инкрементации представлена отдельным методом, который синхронизированн
         между потоками*/

    }
    public synchronized void increment() {
        counter++;
    }
}

