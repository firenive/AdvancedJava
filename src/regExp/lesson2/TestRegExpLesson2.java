package regExp.lesson2;

import java.util.Arrays;

public class TestRegExpLesson2 {
    public static void main(String[] args) {
        /*regExp может также использоваться для метода split()*/
        String a = "Hello there hey";
        String[] z = a.split(" "); // split() делит строку по переданному символу
        System.out.println(Arrays.toString(z)); // [Hello, there, hey]
        String x = "Hello.there.hey";
        String[] z2 = x.split("\\.");
        System.out.println(Arrays.toString(z2)); // [Hello, there, hey]

        // Разделение строки по числам
        String number = "dsfsdf3434fgsdfsdf23123a2";
        String[] numbers = number.split("\\d+"); // сформируются три элемента массива из букв, разделенных цифрами
        System.out.println(Arrays.toString(numbers)); // [dsfsdf, fgsdfsdf, a]

        // replace() позволяет заменить символы на что-то другое
        String b = "Hello there hey";
        String modify = b.replace(" ", ".");
        /* отличия метода replace() от replaceAll заключается в том, что replace() принимает на вход строку, а replaceAll()
        * Принимает на вход регулярное выражение*/
        System.out.println(modify); // Hello.there.hey
        b = "sdsadasd2312312dfdsf343fdsfsda1";
        modify = b.replaceAll("\\d+", "."); // заменяем все цифры на точки
        System.out.println(modify); // sdsadasd.dfdsf.fdsfsda. (заменяет последовательность чисел подряд на символ
        modify = b.replaceAll("\\d", "/");
        System.out.println(modify); // sdsadasd///////dfdsf///fdsfsda/  Заменяет каждую цифру на символ

        modify = b.replaceFirst("\\d+", "*"); // Заменяет только первое совпадение по патерну
        System.out.println(modify); // sdsadasd*dfdsf343fdsfsda1
    }
}
