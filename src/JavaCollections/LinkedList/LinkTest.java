package JavaCollections.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkTest {
    public static void main(String[] args) {
        // Если нужно добавлять элементы в конец списка add() выбирать ArrayList
        // Если нужно производить считывания из листа get() выбирать ArrayList
        // Ечли нужно добавлять элементы не в конец списка (начало, середина) выбирать LinkedList
        List<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        System.out.println(linkedList.get(0));
//        linkedList.size();
//        linkedList.remove(0);


        List<Integer> arrList = new ArrayList<>();
        measureTime(linkedList);
        measureTime(arrList);
        System.out.println("-----------------------");
        measureTime2(linkedList);
        measureTime2(arrList);
        System.out.println("-----------------------");
        measureTime3(linkedList);
        measureTime3(arrList);
    }
    private static void measureTime(List<Integer> list) { // метод будет использоваться для сравнения времени операций
        // в Lists
        long start = System.currentTimeMillis(); // возвращает текущее время в миллисекундах

        for (int i = 0; i < 1000000; i++) { // ПОмещаем в массив миллион объектов. LinkedList  ~ 148 ms, ArrayList ~ 28 ms
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    private static void measureTime2(List<Integer> list) { // Считывание из массива
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) { // Получаем из массива 100000 объектов. LinkedList  ~ 20000 ms, ArrayList ~ 2 ms
            list.get(i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    private static void measureTime3(List<Integer> list) { // add() в начало списка

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i); // каждый следующий элемент добавляется в начало списка LinkedList  ~ 7 ms, ArrayList ~ 130300 ms
            // для ArrayList операция выполняется так долго из-за того что каждый раз при добавлении элемента в начало списка
            // происходит сдвиг правой части массива вправо на 1 элемент и перезапись массива
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        // Хранение элементов для ArrayList: [1][2][3][4][5]
        // в LinkedList хранится не только значения элемента но также ссылка на следующий элемент:
        // head -> [0] -> [1] -> [2] -> [3] -> [4]. Д
        // В основе связного списка лежит понятие узла, или элемента (Node). Узел — это контейнер, который позволяет
        // хранить данные и получать следующий узел.
        // Операция get() для ArrayList выполнялось быстро, так как все элементы получали последовательно по его индексу
        // Операция get для() LinkedList выполнялась медленно, так как прежде чем получить элемент  с нужным индексом
        // необходимо получить на него ссылку. Для этого список каждый раз проходитсяс самого начала.
        // Так, чтобы получить последний элемент N LinkedList необходимо пройти весь массив N раз
    }
}
