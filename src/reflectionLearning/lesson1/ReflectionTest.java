package reflectionLearning.lesson1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) {
        // первый способ получения объекта класса Class
        Class personClass = PersonReflection.class; // Получили объект класса Class, вызвав метод class() на классе
        // PersonReflection

        // второй способ получения объекта класса Class
        PersonReflection newPerson = new PersonReflection();
        Class personClass2 = newPerson.getClass();
        // Получили объект класса Class, вызвав метод getClass() на объекте классе PersonReflection

        // третий способ получения объекта класса Class
        try {
            Class personClass3 = Class.forName("reflectionLearning.lesson1.PersonReflection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Все три способа дают идентичный результат. Объект класса Class

       // Получаем все методы класса PersonReflection и кладем их в массив с типом данных = Method
        Method[] methods = personClass.getMethods(); // import from  java.lang.reflect.Method
        for (Method method : methods) {
            System.out.println(method.getName() + " , " + method.getReturnType()
            + " , " + Arrays.toString(method.getParameterTypes()));
            // получаем имя каждого метода, тип возвращаемого значения, и типы параметров принимаемых на вход метода
            // (method.getParameterTypes()) возвращает массив, для вывода значений применяем toString()

        }
        // результат выполнения
        /*  getName , class java.lang.String , []
            setName , void , [class java.lang.String]
            getId , int , []
            setId , void , [int]
            sayHello , void , []
            wait , void , [long]
            wait , void , [long, int]
            wait , void , []
            equals , boolean , [class java.lang.Object]
            toString , class java.lang.String , []
            hashCode , int , []
            getClass , class java.lang.Class , []
            notify , void , []
            notifyAll , void , [] */
        // получаем все поля
        System.out.println("----------------------------");
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " , " + field.getType()); // notDeclared , class java.lang.String
            // получаем имя поля и тип переменной. Доступны только public поля
        }
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName() + " , " + field.getType()); // notDeclared , class java.lang.String

            // получаем имя поля и тип переменной. Доступны все поля в том числе приватные.
            // Методы getDeclared существуют также для классов, методов, аннотаций и т.д.

            // Вывод
            /*  id , int
                name , class java.lang.String
                notDeclared , class java.lang.String*/
        }
        // получаем все аннотации в классе
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation ann : annotations) {
            if (ann instanceof AuthorReflection) System.out.println("Yep");
            // Если найденнаая аннотация является экземпляром аннотации  AuthorReflection печаем Yep
        }
    }

}
