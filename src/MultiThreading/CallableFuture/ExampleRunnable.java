package MultiThreading.CallableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExampleRunnable {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                    // return 5; Операция невозможно так как метод run() в интерфейсе Runnable не предпологает возврата значений
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
            }
        });
        service.shutdown();
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
