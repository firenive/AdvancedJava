package Lambda.Lesson1;

public class LambdaTest2 {
    public static void main(String[] args) {
        /* Lambda выражение является анонимной функцией (метод без названия). Любые интерфейсы с одним методом удобней
         * реализовывать через Lambda выражения. Если интерфейс содержит 2 или более метода его нельзя реализовать с
         * помощью lambda*/
        Runner2 runner = new Runner2();
        runner.run((x, y) ->  {
            System.out.println("Hello");
            return x + y;
        }); // Если реализация Lambda в одну строчку фигурные скобки не нужны

        runner.run((x, y) -> {
            System.out.println("first line"); // 2 и более строк требуют фигурных скобок
            System.out.println("second line");
            return x + y + 2;
        });
        int z = 12;
        runner.run(new Executable2() {
            @Override
            public int execute(int x, int y) {
                int z = 12; // Так как метод execute имеет свою область видимости, мы можем создать переменную с именем z
                return x + 5;
            }
        });
        runner.run((x, y) -> x + y); // возвращение значения. Тип передаваемого значения писать необязательно
        int a = 10;
        a = 10;
        // runner.run((x, y) -> x + y + a); // плдучаем доступ к переменной a.
        // Variable used in lambda expression should be final or effectively final
        final int a2 = 32;
        runner.run(((x, y) -> x + y + a2));

        /* Если переменная инициализируется значением и это значение по ходу выполнения программы не меняется переменная
         является неявной константой
         Lambda выражения не имеют собственной области видимости */
//        runner.run((x, y) -> {
//            int a = 10; // Variable 'a' is already defined in the scope
//            return a;
//        });
    }
}

interface Executable2 {
    int execute(int x, int y); //  возврат значения прописан либо в анонимном классе при реализации метода либо в Lambda выражении

}

class Runner2 {
    public void run(Executable2 e) {

       int a =  e.execute(10, 15);
        System.out.println(a);
    }
}

