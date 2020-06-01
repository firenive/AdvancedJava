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
    /* переопределим для класса hashCode и equals, для того чтобы сравнение объектов и генерация hashCode производилась
     согласно их полям
     equals отрабатывает довольно долго, так как ему нужно пройтись по всем параметрам передаваемого класа для того
     чтобы оценить равенство. Чтобы ускорить проверку на равество сначала вызывается метод hashCode(),
     который выполняет проверку на равенство быстрее.  Если он отрабатывает правильно, проверка методом equals() не производится
     Если hashCode() вернул неправильный ответ вызывается для проверки долгий метод equals(). Проблема в том, что hashCode()
     Может выдать неправильный ответ, даже если объекты равны. метод equals() обеспечивает более точный ответ

     Хеш-функция  или функция свёртки — функция, осуществляющая преобразование массива входных данных произвольной
     длины в (выходную) битовую строку установленной длины, выполняемое определённым алгоритмом. Преобразование,
      производимое хеш-функцией, называется хешированием. Исходные данные называются входным массивом, «ключом» или
      «сообщением». Результат преобразования (выходные данные) называется «хешем», «хеш-кодом», «хеш-суммой», «сводкой сообщения».

      В Java метод hashCode() преобразует объект любой длинны в целое число {object} -> {int}, так как числа значительно
      легче сравнивать. Слуаи когда у разных объектов одинаковый hashCode называются коллизиями. Они связаны с тем что
      hashCode имеет ограниченное количество значений ограниченных размером переменной int (32 бита). Если при вызове
      метода hashCode() случается коллизия необходимо вызвать метод equals для проверки равенства объектов
     */

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
    /* Контракт hashCode() - equals(): (Данный контракт иполняется например при добавлении элемента в HashMap или Set)
    * 1) у двух проверяемых объектов вызываем метод hashCode()
    * Если:
    * у двух объектов hashCode разный (число int), значит эти объекты разные. Выдаем пользователю, что объекты разные
    * Если:
    * 2) hashCode() одинаковые либо объекты одинаковые либо случилась коллизия. Для того чтобы это проверить дополнительно
    * вызываем метод equals()
    * 3) hasCode() одинаковый, вызываем equals() который выдает точный ответ */
}