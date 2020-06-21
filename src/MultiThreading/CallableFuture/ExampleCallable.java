package MultiThreading.CallableFuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExampleCallable {
    public static void main(String[] args) {
        /* классы Callable и Future позволяют возвращать значения  и выбрасывать исключения из потоков. При использовании
        * интерфейса Runnable пример в классе ExampleRunnable используется метод run() с ключевым словом void. Для того
        * чтобы возвращать значения используем интерфейс Callable, реализация исполняемого потоком кода будет в методе
        * Call*/

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished");
                return random.nextInt(10); // можем вернуть значения типа указанного при реализации интерфейса Callable
            }
        });
        service.shutdown();
        service.submit(() -> {
            System.out.println("Starting");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finished");
            return 10; // При использовании Lambda выражений тип используемого интерфейса (Runnable, Callable)
            // выьирается автоматическию Если что-то возвращается то Callable иначе Runnable
        });
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
    public static int calculate() {
        return 5 + 4;
    }
}
