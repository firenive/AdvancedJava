package JavaCollections.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMap_TreeMap {
    public static void main(String[] args) {
        Map<String, String> translations = new HashMap<>();
        translations.put("кошка", "cat");
        translations.put("собака", "dog");
        translations.put("слон", "elephant");
        for (Map.Entry<String, String> entry : translations.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        /* Проблема HashMap заключается в том, что элементы могут добавляться в одном порядке, но порядок элементов в
         HashMap рандомен и меняется при каждом запуске программы
         Пример вывода:
         слон : elephant
         кошка : cat
         собака : dog*/

        Map<Integer, String> mapTest = new HashMap<>();
        // не гарантируется порядка
        Map<Integer, String> linkTest = new java.util.LinkedHashMap<>();
        // Сохраняется расположение элементов по порядку добавления пары (ключ, значение)
        Map<Integer, String> treeTest = new TreeMap<>();
        // гарантирует, что пары ключ - значение будут отсортированы по ключу. Если ключ = integer, сортировка по
        // большему числу. Если String сортировка по лексикографическому порядку ("по алфавиту")


        System.out.println("-------------------------");
        checkingMap(mapTest); // Порядок не был сохранен. при выводе элементы располагаются рандомно
        // 2 : Evgeniy
        // 4 : Bob
        // 39 : Bob
        // 7 : Alexander
        // 25 : Maksim
        // 12 : Mike
        // 14 : Boris
        System.out.println("-------------------------");
        checkingMap(linkTest); // Элементы вывелись в том порядке, в котором были добавлены в LinkedHashMap
       /* 39 : Bob
        12 : Mike
        14 : Boris
        25 : Maksim
        2 : Evgeniy
        4 : Bob
        7 : Alexander*/
        System.out.println("-------------------------");
        checkingMap(treeTest); // Элементы вывелись в отсортированном порядке относительно ключа
        /*2 : Evgeniy
        4 : Bob
        7 : Alexander
        12 : Mike
        14 : Boris
        25 : Maksim
        39 : Bob*/

    }

    public static void checkingMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(14, "Boris");
        map.put(25, "Maksim");
        map.put(2, "Evgeniy");
        map.put(4, "Bob"); // в Map могут храниться неуникальные значения
        map.put(7, "Alexander");
        for (Map.Entry<Integer, String> entry : map.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}
