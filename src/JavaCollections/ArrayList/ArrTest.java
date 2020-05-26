package JavaCollections.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrTest {
    public static void main(String[] args) {
        int[] x = new int[3]; // Мы не можем поместить в массив больше объектов чем его вместимость
//        for (int i = 0; i <=3; i++) { // ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//            x[i] = i;
//        }
        List<Integer> list = new ArrayList<>(); // по конвенции классы Collections необходимо ссылать на вышестоящий интерфес
        // например ArrayList ссылается на интерфейс List. это позволяет легко сослать объект на другой тип массива
        // Если нам нужно выполнять операции со множеством вставок и копирований в середину списка используем LinkedList
        list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println(list.get(0)); // получение элемента массива по индексу

        System.out.println(list.size()); // 100, размер массива
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        for(Integer z : list) {
            System.out.print(z + " ");
        }
        list.remove(3);
        System.out.println("\n" + list);
    }
}
