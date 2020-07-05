package reflectionLearning.lesson2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionLastLesson {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Считываем строку. 1-ое слово - название 1-ого класса, 2-ое слово - название 2-ого класса,
        // 3-е слово - название Метода. Данные будут введены в одну строчку с пробелами. для получения данных
        // воспользуемся scanner.next()
        try {
            // Создаем объект класса Class по полному имени класса, введенному пользователем
            Class classObject1 = Class.forName(scanner.next());
            Class classObject2 = Class.forName(scanner.next());
            String methodName = scanner.next(); // Получаем имя метода (также вводится пользователем

            Method m = classObject1.getMethod(methodName, classObject2);
            // В качестве первого параметра передаем название метода, который хотим получить. вторым и последующими параметрами
            // передаем типы входных параметров у получаемого класса. В качестве параметра передаем object2

            Object o1 = classObject1.newInstance();
            // будет создан новый объект введенного в строку клсаа с пустым конструктором
            Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

            // Создан новый объект класса String.  в качестве параметра передаем
            // строку "String Value"
            // Аналогично
            String example = "String value";
            m.invoke(o1, o2); // Метод вызывается на объекте o1. В качестве параметра передается o2
            System.out.println(o1);
            /* reflectionLearning.lesson1.PersonReflection java.lang.String setName
                PersonReflection{id=-1, name='String value'}*/
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        /* Было передано: reflectionLearning.lesson1.PersonReflection java.lang.String setName
           Вывод: PersonReflection{id=-1, name='String value'}
           1) Создали объект класса (o1) PersonReflection
           2) Создали объект класса (o2) String. В качестве параметра передали "String Value"
           3) получили из класса PersonReflection метод setName() по его наименованию
           3) у объекта o1 вызвали метод setName() с помощью invoke()
           4) Таким образом создали объект класса PersonReflection и передали ему имя = String Value*/



    }
}
