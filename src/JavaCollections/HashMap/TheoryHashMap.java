package JavaCollections.HashMap;

import java.util.HashMap;
import java.util.Map;

public class TheoryHashMap {
    /* HashMap в своейо основе ипользует для хранения массив связаных списков. То есть в каждом элементе масива хранится
    * связанный список Node<K,. В этих связных списках присутствуют следующие реквизиты:
    * int hash hashCode текущего элемента списка
    * K key - ключ текущего элемента списка
    * V value - значение  текущего элемента списка
    * Node<K, V> next - ссылка на следующий узел */
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("King", 100); // Когда добавляется новый элемент добавляется в HashMap у его ключа подсчитывается hashCode
        /* Вычисляем индекс элемента index = hash & (n -1) где n - размер внутреннего массива
         умножаем вычисленный hashCode побитово на размер массива - 1. Это позволит присвоить новому элементу индекс в
         рамках размера массива. Операция аналогична целочисленному делению. index = hash / (n-1). При этом ссылки
          на следующий узел не будет, так как это единственный элемент в списке */
        scores.put("Clark", 90);
        scores.put("Blake", 10);
        /* Если при вычислении index он совпадет с индексом ранее добавленного элемента новый элемент длбавится в конец
        * связанного списка. Ниже демонстрируется ситуация
        * index = 2. Clark[hash = 25947681 | 90] Node next = null (ссылка на следующий узел)
        * index = 4. King[hash = 23067996 | 100] -> Blake[hash = 62381940* | 10] */
        scores.put("Ford", 110);
        scores.put("Ward", 99);

        // операция получения элемента по ключу
        scores.get("Clark");
        /*  Высчитываем индекс передаваемого ключа и высчитываем индекс, элемента в HashMap */
    }
}
