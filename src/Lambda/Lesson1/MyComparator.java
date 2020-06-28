package Lambda.Lesson1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyComparator {
    /* Сделаем новый компаратор, сортирующий строки по их длине*/
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Goodbye");
        list.add("new");
        list.add("124342525");
        list.sort(new Comparator<String>() { // реализация компаратора с анонимными классами
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length() ) return 1;
                else if (o1.length() < o2.length()) return -1;
                return 0;
            }
        });
        list.sort((o1, o2) -> { // реализация с помощью lambda выражений
            if (o1.length() > o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
            return 0;
        } );
        // Lambda выражения можно записывать в переменные
        Comparator<String> comparator = (o1, o2) -> {
            if (o1.length() > o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
            return 0;
        };
    }
}
