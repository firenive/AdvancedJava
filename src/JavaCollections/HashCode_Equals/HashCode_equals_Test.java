package JavaCollections.HashCode_Equals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashCode_equals_Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        map.put(1, "Один");
        map.put(1, "Другое значение");
        set.add(1);
        set.add(1);
        System.out.println(map); // {1=Другое значение}
        System.out.println(set); // [1]
        System.out.println("-------------");
        // так как значения не уникальны Map переписал значение у ключа, а Set Добавил только 1 значение

        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Mike");

        Map<Person, String> persons = new HashMap<>();
        Set<Person> setPersons = new HashSet<>();

        persons.put(person1, "Human");
        persons.put(person2, "Human");

        setPersons.add(person1);
        setPersons.add(person2);

        System.out.println(persons);
        System.out.println(setPersons);
        /*{Person{Id = 1; Name = Mike}=Human, Person{Id = 1; Name = Mike}=Human}
        [Person{Id = 1; Name = Mike}, Person{Id = 1; Name = Mike}]*/

        /* несмотря на то что параметры у двух объектов класса Person одинаковы они прошли проверку на уникальность
         при добавлении в Set and HashMap. Произошло это потому что person1 и person2 это разные объекты класса Person.
          Проверки на идентичность параметров и их реализации внутри класса не происходит */
        Set<String> setString = new HashSet<>();
        setString.add("first");
        setString.add("first");
        System.out.println(setString); // [first]
        // Такого не происходит для класса String, Так как в классе String переопределен метод HashCode


        Integer x = 2;
        System.out.println(x.equals(2)); // true
        System.out.println(x.hashCode()); //  2
        // Реализация equals в классе Object сравнивает ссылки двух разных объектов, не проверяя параметры объектов
        // Но например в классу Integer equals переопределен и сравнивает значения
        // if (obj instanceof Integer) {
        //            return value == ((Integer)obj).intValue();
        //        }

    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "Id = " + id + "; Name = " + name + "}";
    }
    // переопределим для класса hashCode и equals, для того чтобы сравнение объектов и генерация hashCode производилась
    // согласно их полям
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}