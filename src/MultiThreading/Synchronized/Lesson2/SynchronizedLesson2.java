package MultiThreading.Synchronized.Lesson2;

public class SynchronizedLesson2 {
    private int counter;
    // Перепишем метод increment для явного определения объекта, по которому должна выполняться синхронизация
    public void increment() {
         /*Конструкция называется synchronized блок. При ее использованиии ключевое слово метода убирается
         * При этом синхронизируется не весь код в методе, а только код присутствующий в блоке. Метод System.out.println(1);
         * синхронизирован не будет. В качестве параметра блоку передается объект на основании которого будет выполнена
         * синхронизация */
//        synchronized () {
//        }
        // System.out.println(1);
    }

    public static void main(String[] args) throws InterruptedException {


        SynchronizedLesson2 test = new SynchronizedLesson2();
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


    }

}

