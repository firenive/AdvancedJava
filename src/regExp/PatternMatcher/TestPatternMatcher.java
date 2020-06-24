package regExp.PatternMatcher;

import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPatternMatcher {
    public static void main(String[] args) {
        /* Класс Pattern представляет собой само регулярное выражение. Класс Matcher использует Pattern для того чтобы
        проводить свои операции над строкой. Популярное использование этих классов - поиск паттернов в тексте (совпадений)
         В качестве примера найдем emails в тексте ниже*/
        String text = "Hello, Guys! i send you my email joe@gmail.com so we can\n" +
                "keep in touch. Thanks, Joe! That's cool. I am sending you\n" +
                "my address: tim@yandex.ru. Let's stay in touch...";
        Pattern email = Pattern.compile("\\w+@(gmail|yandex)\\.(com|ru)"); // Пример паттерна
        // new Pattern(); // Выдает ошибку
        // у класса Pattern приватный коструктор. Напрямую нельзя создать объект класса. Метод compile() после своей работы
        // возвращает новый объект класса. В качестве параметра принимает регулярное выражение. Его будем искать в тексте
        Matcher match = email.matcher(text); /*объект класса matcher создается путем вызова на объекте класса Pattern метода
        matcher. В качестве параметра передается строка, где будем искать паттерн (электронную почту)*/

         /*find() ищет ссответствие паттерну. Сначала find()Найдет первое значение подходящее паттерну и вернут true.
         * Далее цикл продолжится до тех пор пока все паттерны в тексте не будут найдены*/

        while (match.find()) {
            System.out.println(match.group()); // Возвращает то что было найдено методом find
//            joe@gmail.com
//            tim@yandex.ru
        }
        /*Метод group() без параметров возвращает всю строку, соответствующую паттерну. Можно в метод group передать целое
        * число, являющееся id группы. Группа в регулярном выражении - любая строка, находящаяся в круглых скобках
        * Например (gmail|yandex) или (com|ru)*/

        // В качестве примера. Нам нужно получать email не полностью, а только имя (до @)
        Pattern email2 = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");
        Matcher match2 = email2.matcher(text);
        // включаем \\w+ (имя) в скобки
        while (match2.find()) System.out.print(match2.group(1) + " "); // joe tim

        while (match2.find()) {
            String result = match2.group(2);
            System.out.print(result + " ");
        }
        System.out.println();
        Matcher match3 = email2.matcher(text);
        while (match3.find()) System.out.println("Match3  " + match3.group(2));
    }
    /* нумерация id групп идет слева- направо. (1)(2)(3). Если есть вложенности нумерация идет следующим образом. Внешней
    * группе присваивается наименьший номер. Чем больше группа вложена тем больше номер (1 (2) (3) )
    * (1(2)) (3). Если группа имеет вложения номера присваиваются ей, а потом ее вложенным группам. Далее рассматривается
    * следующая группа не вложение первой*/
}
