package JavaCollections.LinkedList;

import java.util.Arrays;

public class MyLinkedList {
    // Создадим пример реализации класса LinkedList. Реализовывать будем односвязный непараметризованный список хранящий
    // целые чмсла
    private Node head; // Головной узел
    private int size; // размер листа

    public void add(int value) { // добавление нового элемента в список
        // Если первое добавление элемента в список
        if (head == null) {
            this.head = new Node(value);
        } else { // Последующие добавления. Нужно дойти до конца списка и последнему узлу указать в качестве следующего
            // новый добавляемый узел
            Node temp = head; // temp является узлом, который по сути выполняет роль итератора массива
            while (temp.getNext() != null) { // цикл проходит по всем узлам в списке пока не достигает последнего элемента
                temp = temp.getNext();
            }
            temp.setNext(new Node(value)); // назначаем следующий узел с передаваемым значением. таким образом
            // добавляется новый элемент

            // [1] -> [2] -> [3] head в начале указывает на первый элемент. Ссылаем temp на head (то есть на первый элемент)
            // после этого последовательно проходим весь список. на каждой итерации цикла temp = следующему узлу в списке
            // У последнего элемента в списке нет следующих узлов поэтому список заканчивается
            // head всегда будет указывать на первый узел
        }
        size++; // при каждом добавлении элемента увеличиваем размер листа на 1
    }
    public int get(int index) { // Метод получения элемента в списке по его индексу
        int currentIndex = 0; // указывает на текущий индекс
        Node temp = head;
        while (temp != null) {
            if (currentIndex == index) { // Если дошли до нужного индекса возвращаем его значение
                return temp.getValue();
            } else {
                currentIndex++;
                temp = temp.getNext();
            }
        }
        throw new IllegalArgumentException(); // Если элемента нет в списке выбрасываем исключение
    }
    public void remove(int index) { // Метод удаления объекта из массива будет схож с get(). Нужно дойти до элемента
        // предшествующего удаляемому элементу, поскольку ссылка на удаляемый элемент хранится в предыдущем объекте
        // [1]->[2]->[3] Для удаления двойки из массива следует у единицы[0] изменить узел. Узел будет указывать не на двойку[1],
        // а на тройку[2]. таким образом элемент под индексом[1] будет удален из массива
        if (index == 0) { // удаление первого элемента в листе
            head = head.getNext();
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if(currentIndex +1 == index) {
                temp.setNext(temp.getNext().getNext()); // Назначаем текущему узлу (единица[0]) узел через одного (тройка[2])
                size--;
                return; // после удаления объекта выходим из метода
            } else { // Если удаляется последний элемент, то ему присваивается узел через 1 = null
                temp = temp.getNext();
                currentIndex++;
            }
        }


    }

    @Override
    public String toString() { // чтобы вывести все элементы списка необходимо пройтись по всему списку, записать во временный
        // массив все его элементы и после этого вывести этот объект
        int[] result = new int[size];
        int idx = 0;
        Node temp = head;
        while (temp != null) {
            result[idx++] = temp.getValue();
            temp = temp.getNext();

        }
        return Arrays.toString(result);

    }

    private static class Node { // класс описывающий узел
        private int value;
        private Node next; // Следующий узел

        public Node (int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }

    }
}
