package Lambda.Lesson1;

public class LambdaTest {
    public static void main(String[] args) {
        /* Lambda выражение является анонимной функцией (метод без названия). Любые интерфейсы с одним методом удобней
        * реализовывать через Lambda выражения*/
        Thread thread = new Thread(() -> { // создание потока с помощью lambda выражения
            System.out.println("Thread");
        });
        Runner runner = new Runner();
        runner.run(new ExecutableImplementation()); // первый способ реализации метода run с помощью класса, реализовывающего
        // интерфейс Executable
        runner.run(new Executable() { // Сопосб № 2. Реализация с помощью анонимного класса
            @Override
            public void execute() {
                System.out.println("Hello");
            }
        });
        runner.run(() -> System.out.println("Hello")); // Способ № 2. Реализация с помощью lambda
    }
}
interface Executable {
    void execute();

}
class ExecutableImplementation implements Executable {

    @Override
    public void execute() {
        System.out.println("Hello");
    }
}
class Runner {
    public void run(Executable e) {
        e.execute();
    }
}

