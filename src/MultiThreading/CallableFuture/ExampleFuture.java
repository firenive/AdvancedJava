package MultiThreading.CallableFuture;

import java.util.Random;
import java.util.concurrent.*;

public class ExampleFuture {
    public static void main(String[] args) {
        /* Класс Future позволяет получить доступ к возвращаемому значению из потока*/

        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> future = service.submit(() -> {
            Random random = new Random();
            System.out.println("Starting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finished");
            int randomValue = random.nextInt(10);
            if (randomValue < 5) throw new Exception("Something bad happened");
            // Также Callable и Future позволяют выбрасывать исключения
            return random.nextInt(10); // можем вернуть значения типа указанного при реализации интерфейса Future

        });
        service.shutdown();
        try {
            // get дожидается окончания выполнения потока
            int result = future.get(); // получаем значение из потока и кладем его в переменную типа int
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            Throwable ex = e.getCause(); // получаем причину исключения
            System.out.println(ex.getMessage()); // выводим сообщениие на экран "Something bad happened"
            e.printStackTrace(); // выбрасываемое потоком исключение будет поймано здесь благодаря ExecutionException
        }
    }
}
