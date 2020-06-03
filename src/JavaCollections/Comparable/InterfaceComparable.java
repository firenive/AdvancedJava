package JavaCollections.Comparable;

import java.util.*;

public class InterfaceComparable {
    public static void main(String[] args) {
        /* В этом классе необходходимо используя интерфейс Comparable добавить естественный порядок сортировки для класса
         PersonComparable. Иначе при добавлении объектов класса PersonComparable в TreeSet получаем ошибку
         Exception in thread "main" java.lang.ClassCastException: class JavaCollections.Comparable.
         PersonComparable cannot be cast to class java.lang.Comparable
         Та же ошибка будет при попытке сортировать ArrayList методом Collections.sort()
         Для того чтобы задать естественный порядок сортировки необходимо в классе PersonComparable рееализовать метод
         compareTo(). Для этого ркализуем интерфейс Comparable*/
        List<PersonComparable> peopleList = new ArrayList<>();
        Set<PersonComparable> peopleSet = new TreeSet<>();
        addElement(peopleList);
        addElement(peopleSet);
        System.out.println(peopleList);
        System.out.println(peopleSet);
    }
    private static void addElement(Collection collection) {
        collection.add(new PersonComparable(1, "Bob"));
        collection.add(new PersonComparable(2, "Tom"));
        collection.add(new PersonComparable(16, "Katy"));
        collection.add(new PersonComparable(25, "George"));


    }
}

class PersonComparable implements Comparable<PersonComparable>{ // реализуем интерфейс Comparable
    private int id;
    private String name;

    public PersonComparable(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PersonComparable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonComparable that = (PersonComparable) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override // Сравниеваем объекты класса по id. Порядок возрастающий
    public int compareTo(PersonComparable o) { // В методе указывается порядок сравнения объектов этого класса
        if( this.id > o.getId()) return 1;
        if (this.id < o.getId()) return -1;
        return 0;
    }
}
