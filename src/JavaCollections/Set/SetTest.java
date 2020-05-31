package JavaCollections.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    // Особенность коллекции Set (множество) заключается в том, что она хранит в себе только уникальные значения элементов

    public static void main(String[] args) {
        // Три вида множестив: HashSet, LinkedHashSet, TreeSet
        Set<String> hashSet = new HashSet<>(); // не хранит порядок элемнтов
        Set<String> linkSet = new LinkedHashSet<>(); // элементы храняться в порядке добавления
        Set<String> treeSet = new TreeSet<>(); // Автоматическая сортировка элементов
        testSet(hashSet);
        // Mike   Alexander   Bob   Jakob   Augustin   Elena
        testSet(linkSet);
        //  Mike   Bob   Alexander   Jakob   Elena   Augustin
        testSet(treeSet);
        // Alexander   Augustin   Bob   Elena   Jakob   Mike

        // проверка на вхождение элемента во множестве. Метод отрабатывает за константное время O(1) так как каждый элемент
        // в Set хэширован. Если предстоит выполнять много операций на проверку вхождения и не важен порядок использовать HashSet
        System.out.println(hashSet.contains("Bob")); // true
        System.out.println(hashSet.contains("Tim")); // false
        System.out.println(hashSet.isEmpty()); // false Проверка на пустоту множества

        // Если в Set происходит вставка неуникального значения элемент не добавляется во множество. его вставка игнорируется
        hashSet.add("Tom");
        hashSet.add("Tom");
        System.out.println("--------------------");
        System.out.println(hashSet); //  метод toString в Set переопределен
        // [Alexander, Mike, Tom, Bob, Jakob, Augustin, Elena]   Только одно значение имени "Tom"

        // По теории множеств с множествами можно производить 4 дополнительные операции: intersect (пересечение),
        // union (Объединение), subtract (Разность), exclusiveOr (симметрическая разность

        // Union (Объединение) собирает в себе все элементы двух множеств
        System.out.println("--------------------");
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        fillSet(a, 0, 10);
        fillSet(b, 5, 15);
        System.out.println(a); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(b); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        Set<Integer> union = new HashSet<>(a); // Конструктор HashSet может принимать в качестве аргументов
        // другие множества. Положим в множество union множество a (все элементы a скопируются в множество union)
        union.addAll(b);
        System.out.println("--------------------");
        System.out.println(union); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
        // Результатом объединения множеств является все элементы содержащиеся в них без дублей

        // Intersection (Пересечение)результатом пересечения двух множеств является элементы, которые содержатся и в
        // первом и во втором множестве
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("--------------------");
        System.out.println(intersection); // [5, 6, 7, 8, 9, 10] Элементы, которые есть и в первом и во втором множестве

        // difference (Разность множеств)
        System.out.println("--------------------");
        Set<Integer> subtract = new HashSet<>(a);
        subtract.removeAll(b); // Будут сохранены только уникальные элементы первого множества, которые отсутствуют во втором
        System.out.println(subtract); // [0, 1, 2, 3, 4]

    }

    public static void testSet(Set<String> set) {
        set.add("Bob");
        set.add("Alexander");
        set.add("Jakob");
        set.add("Mike");
        set.add("Elena");
        set.add("Augustin");
        for (String name : set) {
            System.out.print(name + "  ");
        }
        System.out.println("\n--------------------");
    }
    public static void fillSet(Set<Integer> set,int begin, int end) {
        for (int i = begin; i <= end; i++) {
            set.add(i);
        }
    }
}
