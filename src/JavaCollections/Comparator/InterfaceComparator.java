package JavaCollections.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InterfaceComparator {
    public static void main(String[] args) {
        // Сортировка объектов в JavaCollections
        /* Сортируют только коллекции, сохраняющие внутри себя порядок: ArrayList, LinkedList, TreeList, TreeSet, LinkedSet
         TreeMap, LinkedMap */
        List<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");
        animals.add("bird");
        animals.add("z");
        animals.add("xx");
        animals.add("ssssssssss");
        Collections.sort(animals); // Строки по умолчанию (natural order)
        // сортируются по лексикографическому порядку a -> b -> c -> d etc
        System.out.println(animals); // [bird, cat, dog, frog, ssssssssss, xx, z]

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(100);
        numbers.add(16);
        numbers.add(0);
        numbers.add(-2);
        numbers.add(-21);
        numbers.add(100);
        Collections.sort(numbers); // natural order sort()
        System.out.println(numbers); // [-21, -2, 0, 5, 16, 100, 100]

        /*  для определения собственного порядка сортировки используется интерфейс Comparator. Для собственной реализации
        порядка сортировки (Например, сортировка строк по их длине создается класс, реализующий интерфейс Comparator */
        Collections.sort(animals, new MyComparator());
        System.out.println(animals); // [z, xx, cat, dog, bird, frog, ssssssssss] Сортировка по длине строки

        Collections.sort(numbers, new SortNumbers());
        System.out.println(numbers); // [100, 100, 16, 5, 0, -2, -21]

        // Если нужно использовать компоратор только один раз можно не создавать отдельный класс, а использовать анонимные классы
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                else if (o1 < o2) return -1;
                return 0;
            }
        });
        System.out.println(numbers); // [-21, -2, 0, 5, 16, 100, 100]

        List<Person> people = new ArrayList<>();
        people.add(new Person(121, "Pavel"));
        people.add(new Person(178, "Inna"));
        people.add(new Person(12, "Mika"));
        people.add(new Person(544, "Zixel"));
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()) return 1;
                if (o1.getId() < o2.getId()) return -1;
                return 0;
            }
        });
        System.out.println(people);
        // [Person{id=12, name='Mika'}, Person{id=121, name='Pavel'}, Person{id=178, name='Inna'}, Person{id=544, name='Zixel'}]
    }
}
class SortNumbers implements Comparator<Integer> { // сортировка чисел в обратном порядке

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o2 > o1) return 1;
        else if (o2 < o1) return -1;
        return 0;
    }
}
class Person {
    int id;
    String name;
    public Person (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
