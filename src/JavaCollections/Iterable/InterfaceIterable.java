package JavaCollections.Iterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InterfaceIterable {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 22, 13, 54, 16));
        /* Все коллекции позволяют использовать цикл foreach для прохождения по всем элементам массива. за это отвечает
         * реализованный у каждой коллекции интерфейс Iterable. Интерфейс содержит в себе метод Iterator<T> который
         *  возвращает объект класса итератор, который позволяет проходиться по элементам коллекции. Если по элементам
         * создаваемого класса также нужно проходится необходимо реализовывать метод iterator */

        // Реализация итерирования до Java 5. Данный способ устаревший
        Iterator<Integer> iter = list.iterator(); // В элементе описана логика прохождения по коллекции
        while (iter.hasNext()) System.out.print(iter.next() + " "); // 1 22 13 54 16
        System.out.println("\n---------------");
        // Такая реализация итерирования появилась в Java 5. "Под капотом" происходит то же самое, что описано выше
        for (int x : list) {
            System.out.print(x + " "); // 1 22 13 54 16
        }
        System.out.println("\n----------------------------");
        /* отличия в указанных способах заключаются в том, что при использовании Iterator как объекта мы можем изменять
         * объект над которым производится итерирование (например удалять элементы). Цикл foreach такого не позволит*/

        List<Integer> list2 = (ArrayList<Integer>) list.clone();
        Iterator<Integer> iterator2 = list.iterator();

        int idx = 0;
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " "); // элементы не печатаются, так как сначала удаляются
            if (idx == 2) iterator2.remove(); // Удаление элемента под индексом 2. Можно удалять только текущий элемет
            idx++;
        }
        System.out.println("\n" + list); // [1, 22, 54, 16]

        System.out.println("----------------------------");

        for (int z : list2) { // При попытке изменить список во время цикла foreach(удаление элементов выдается ошибка
            list.remove(1);
            System.out.print(z + " ");
        }
        /* 1 22 13 54 Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
	at java.base/java.util.Objects.checkIndex(Objects.java:372)
	at java.base/java.util.ArrayList.remove(ArrayList.java:535)
	at JavaCollections.Iterable.InterfaceIterable.main(InterfaceIterable.java:38) */

    }
}
