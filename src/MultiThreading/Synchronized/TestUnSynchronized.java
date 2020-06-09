package MultiThreading.Synchronized;

public class TestUnSynchronized {
    private int counter;

    public static void main(String[] args) throws InterruptedException {

        /*Ключевое слово volatile используется для синхронизации в  том случае, если один поток пишет в переменную
         * а все остальные потоки читают из этой переменной
         * Ключевое слово synchronized используется в той ситуации когда несолько потоков пишут в одну и ту же переменную */
        TestUnSynchronized test = new TestUnSynchronized();
        test.doWork();
    }

    public void doWork() throws InterruptedException { // создадим 2 потока, которые одновременно будут инкрементировать переменную counter
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                    // System.out.println(counter + "  Thread1");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                    // System.out.println(counter + "  Thread2");
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join(); // ждем выполнение потоков. Ждем в текущем потоке main пока завершится поток thread1
        thread2.join();
        System.out.println("Result:" + counter);
        /* Общее значение переменной очень часто не равно 20000. Протсходит это из-за того что потоки не синхронизированы
        * между собой. Происходит ситуация когда потоки могут перезаписывать значения переменной не обращая внимания на
        * то что другой поток уже инкрементировал эту переменную до большего значения
        * 1 поток: 100 (значение сохраненное в памяти) -> 101 -> 102 -> 103 (Сохраняет значение в память)
        * 2 поток (не учитывает работу первого потока и свою инкрементацию начинает со 100)
        * 2 поток: 100 (сохраненное значение) -> 101 ->102 -> 103 -> 104 -> 105. Теряется три итерации цикла выполненные
        * первым потоком, так как второй поток не знает о нем и данные не синхронизированны */

        // реализуем синхронизацию в классе TestSynchronized
    }


}

