package Lambda.Lesson2;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaForCollections {
    private static Random random= new Random();
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();
        fillArr(arr);
        fillList(list);
        System.out.println(Arrays.toString(arr));
        System.out.println(list);

        // Необходимо увеличить каждый элемент массива и листа на 2
//        for (int i = 0; i < 10; i++) {
//            arr[i] = arr[i] *2;
//            list.set(i, list.get(i) * 2);
//        }
        // Realization with lambda
         /*метод stream (статический у класса Arrays. в качестве параметра передается массив необходим для того чтобы
         * lambda могла оперировать данными в массиве. Метод map() берет каждый элемент в массиве и сопоставляет ему новый
         * элемент, меняет его отображение. Метод map итерируется по каждому элементу массиваи меняет его на то, что
         * возвращает lambda выражение. После этого необходимо выполнить обратное преобразование в массив, list*/

        // map method
        arr = Arrays.stream(arr).map(a -> a* 2).toArray();
        list = list.stream().map(a -> a *2).collect(Collectors.toList()); // умножаем все элементы на 2
        list = list.stream().map(a -> 3) .collect(Collectors.toList()); // всем элементам в List сопоставится 3
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        System.out.println("--------------------");


         /*filter method. Фильтрует данные в массиве по какому-либо признаку. Условие пишется в раздел return описываемого
         * lambda выражения. Элементы не подходящие под условие удаляются из массива */
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();
        fillArr(arr2);
        fillList(list2);
        arr2 = Arrays.stream(arr2).filter(a -> a %2 == 0).toArray();
        list2 = list2.stream().filter(a -> a %3 == 0).collect(Collectors.toList());
        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        // forEach необходим для итерирования массивов, листов
        Arrays.stream(arr2).forEach(a -> System.out.print(a + " "));
        list2.forEach(System.out::print);
        System.out.println("\n---------------------------");

        // method reduce(). Берет набор данных и сжимает его в один элемент
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();
        fillList(list3);
        fillArr(arr3);
        /*Подсчитаем сумму  и произведение элементов в массиве с помощью метода reduce(). В качестве параметров передаем
        элемент счетчик acc. параметр b обозначает текущий элемент списка. По умолчанию acc = значению первого элемента
        списка. при необходимости значения acc можно задать вручную. На каждой итерации цикла текущее значение acc
        прибавляет к себе. Если начальное щначение acc не указано итерация списка начинается с индекса 1. Если
        указано итерация идет с 0 индекса */
        int sum = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt();
        int sumList = list3.stream().reduce(0,(acc, b) -> acc * b); // ручное задание acc = 0
        sumList = list3.stream().reduce((acc, b) -> acc * b).get();

        // все рассмотренные элементы могут вызываться цепочкой. Оставим в массиве только нечетные числа и умножим их на 2
        int[] arr4 = new int[10];
        fillArr(arr4);
        System.out.println("Arr4 " + Arrays.toString(arr4));
        arr4 = Arrays.stream(arr4).filter((a) -> a% 2 !=0).map((b) -> b *2).toArray();
        System.out.println(Arrays.toString(arr4));
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        System.out.println(set);
        set = set.stream().map((a) -> a* 2).collect(Collectors.toSet());
        System.out.println(set);



    }
    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(20));
        }
    }
    private static void fillArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
    }
}
