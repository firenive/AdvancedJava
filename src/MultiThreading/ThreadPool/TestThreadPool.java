package MultiThreading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        /* на прошлых уроков создавались потоки явно, путем создания объектов класса Thread либо используя интерфейс
        Runnable. Здесь изучим другой метод создания потоков ThreadPool. При этом методе создается n-число потоков,
        которые выполняют задание параллельно */

        ExecutorService service = Executors.newFixedThreadPool(2);
        /* Создаем объект класса ExecutorService, который позволяет создать и использовать Пул потоков. Передаем ему
        результат работы  статического метода newFixedThreadPool класса Executors. В качестве параметра передаем количество
        потоков, которые необходимо создать*/

        for (int i = 0; i < 5; i++) { // Дадим созданному пулу из двух потоков 5 заданий
            service.submit(new WorkPool(i)); /* В метод submit() передается класс реализующий интерфейс Runnable. Пул потоков
             реализует задание описанное в методе run(). При создании объекта WorkPool передаем id. На каждой итерации цикла
             создается новый объект, которому присваивается id = i. Таким образом всего будет создано и выполнено 5 заданий
             описанных в методе run()*/
        }
        service.shutdown(); // Метод сообщающий, что распределение заданий закончено. Запускает выполнение переданных методом
        // submit() заданий. Два потока начинают выполнение 5 переданных заданий
    }
}
class WorkPool implements Runnable {
    private int id;
    public WorkPool(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Work " + id + " was completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}