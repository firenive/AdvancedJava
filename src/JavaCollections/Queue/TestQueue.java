package JavaCollections.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TestQueue {
    public static void main(String[] args) {
        /* еще один интерфейс Collections это Queue (Очередь). В нем хранятся элементы согласно порядку их добавления
         Один из сценариев использования это реализация очереди в потоках. для распределения доступа к данным между потоками
         по времени ожидания доступа к ресурсу. Рассмотрим реализацию интерфейса Queue на примере класса LinkedList*/
        PersonQueue person1 = new PersonQueue(1);
        PersonQueue person2 = new PersonQueue(2);
        PersonQueue person3 = new PersonQueue(3);
        PersonQueue person4 = new PersonQueue(4);

        Queue<PersonQueue> people = new LinkedList<>();

        people.add(person3);
        people.add(person2);
        people.add(person4);
        people.add(person1);
        for (PersonQueue person : people) {
            System.out.print(person + " "); // Person{id=3} Person{id=2} Person{id=4} Person{id=1}
        }
        System.out.println("\n----------------------");

        // Рассмотрим еще один пример реализации интерфейса Queue это класс ArrayBlockingQueue
        Queue<PersonQueue> blockingPeople = new ArrayBlockingQueue<>(10); // В конструкторе обязательно
        // указывается максимальный размер очереди. Если размер очереди превышен новые объекты не будут добавляться
        blockingPeople.add(person3);
        blockingPeople.add(person2);
        blockingPeople.add(person4);
        blockingPeople.add(person1);

        System.out.println(blockingPeople.remove()); // удаляет первый элемент в очереди (person3) и выводит на экран Person{id=3}
        System.out.println(blockingPeople); // [Person{id=2}, Person{id=4}, Person{id=1}]

        System.out.println(blockingPeople.peek()); // Метод позволяет посмотреть первого человека в очереди не удаляе его
        // Person{id=2}
        /* Есть две пары методов для добавления элементов в очередь add() offer(), удаления элементов из очереди
        * remove() poll() и получению головного элемента из очереди element() peek().
        *
        * Методы add(), remove(), element()  случае какой либо ошибки выбрасывают исключение.
        * Методы offer(), poll(), peek() в случае ошибки возвращают специальное значение*/

        // add()
        Queue<PersonQueue> peopleAdd = new ArrayBlockingQueue<>(3);
        peopleAdd.add(person3);
        peopleAdd.add(person2);
        peopleAdd.add(person4);
        // peopleAdd.add(person1); // исключение при добавление 4 элемента в максимальную длину очереди = 3
        // Exception in thread "main" java.lang.IllegalStateException: Queue full

        // offer() Если смог добавить элемент возвращает true иначе возвращает false
        Queue<PersonQueue> peopleOffer = new ArrayBlockingQueue<>(3);
        System.out.println(peopleOffer.offer(person3));  // true
        System.out.println(peopleOffer.offer(person2)); // true
        System.out.println(peopleOffer.offer(person4)); // true
        System.out.println(peopleOffer.offer(person1)); // false
        // Для remove(), poll() и element() peek() действует та же логика
    }

}

class PersonQueue {
    private int id;

    public PersonQueue(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
