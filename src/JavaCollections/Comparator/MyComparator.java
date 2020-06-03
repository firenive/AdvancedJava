package JavaCollections.Comparator;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) { // сравнение строк по длине
        // По конвенции описаниия метода compare. Если первый передаваемый объект > второго возвращаем 1
        if (o1.length() > o2.length()) return 1;
        else if (o1.length() < o2.length()) return -1; // Если второй объект больше 1 возвращаем -1
        return 0; // если объекты равны возвращаем 0
    }
}
