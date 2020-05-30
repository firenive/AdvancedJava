package JavaCollections.HashMap;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer, String > map = new HashMap<>(); // сначала указывается формат ключа, потом формат значений
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println(map); // {1=One, 2=Two, 3=Three}
        map.put(3, "Another value");
        System.out.println(map); // {1=One, 2=Two, 3=Another value}. При добавлении ключа, который уже есть в списке
        // новый ключ не создается. Переписывается значение. Ключи в HashMap уникальны

        System.out.println(map.get(1)); // получаем значение по ключу
        System.out.println(map.get(5)); // null. Если ключа нету в hashMap возвращается null

        System.out.println("-------------------------"); // Класс HashMap не гарантирует порядка. данные могут выводиться
        // не так как они расположены, а рандомно
        for(Map.Entry<Integer, String> entry: map.entrySet()) { // Entry = пара "ключ- значение"
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        // HashMap используется если порядок извлечения элементов не важен

    }
}
