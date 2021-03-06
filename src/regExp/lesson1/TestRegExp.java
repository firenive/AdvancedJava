package regExp.lesson1;

public class TestRegExp {
    public static void main(String[] args) {
        /*Regexp представляет собой группу символов или знаков, которая используется для поиска определенного текстового
         шаблона. Регулярное выражение – это шаблон, который сравнивается с предметной строкой слева направо. Словосочетание
         “regular expression” применяется не так широко, вместо него обычно употребляют “regex” и “regexp”. Регулярное
         выражение используется для замены текста внутри строки, проверки формы, извлечения подстроки из строки на основе
         соответствия шаблона и т. д.*/
        String a = "1234";
        System.out.println(a.matches("1234")); // true
        // matches() вернет true, если строки в объекте на котором вызывается метод и строка в переданном параметре совпадают
        System.out.println(a.matches("1235")); // false

        /* Но в matches можно передавать не только строки, а регулярные выражения. Примеры регулярных выражений:
        * '\\d' - одна цифра (Двойной слэш обозначает, что это специальный символ
        * '+' - 1 или более символов
        * '*' - 0 или более символов
        * '?' - сообщает о том, что символ, который идет до вопросительного знака может быть, а может не быть
        * '(x|y|z)' - В скобках описываются возможные символы. Между символами используется знак или |
        * [a-zA-Z] -  можем описать множество выражений. В примере описали все английский буквы от a-z в двух регистрах
        * [0-9]  = \\d
        * [^abc] - Символ обозначает отрицаниее. match выдаст false если символы 'a' or 'b' or 'c' есть в строке
        * '.' - любой символ
        * {2} - Количество предыдущих символов (\\d{2}) Например хотим видеть две цифры
        * {2, } - От двух символов (2 или более). (\\d{2, }) Две и более цифры
        * {2, 4} - от двух до 4 символов
        * \\w - одна буква. Аналогично [a-zA-Z]  */
        String a1 = "d";
        System.out.println(a1.matches("\\d")); // false
        a1 = "1";
        System.out.println(a1.matches("\\d")); // true. Строка в которой одна цифра
        a1 = "a5";
        System.out.println(a1.matches("\\d")); // false
        a1 = "12121";
        System.out.println(a1.matches("\\d")); // false
        System.out.println(a1.matches("\\d+")); // true (1 и более символов строго относятся к цифрам)

        a1 = "";
        System.out.println(a1.matches("\\d+")); // false так как ждет 1 символ цифру или более
        System.out.println(a1.matches("\\d*")); // true, Так каквозвращает true, если строка не содержит символов
        a1 = "-343";
        String b = "34245";
        // Если число отрицательное требуется добавить знак минуса перед регулярным выражением
        System.out.println(a1.matches("-\\d+")); // true
        // Выражение должно возвращать true на положительные и отрицательные числа. Используем '?'
        System.out.println(a1.matches("-?\\d+")); // true на положительное число
        System.out.println(b.matches("-?\\d+")); // true на отрицательное число

        // Перед числом может стоять не только символ '-', А также '+'. Опишем эту ситуацию. Так как '+' совпадает со
        // специальным символом регулярных выражений необходимо его экранировать с помощью \\
        String c = "+2321312";
        System.out.println(c.matches("(-|\\+)?\\d+")); // true
        System.out.println(a1.matches("([-+])?\\d+")); // true. Поддерживается такая запись. Все символы записываются в
        // квадратных скобках
        System.out.println(b.matches("([+-])?\\d+")); // true если перед числом нету симолов

        // Рассмотри читуацию если перед числом стоит буква
        String d = "A2131232"; // Любая буква английского алфавита в верхнем, нижнем регистре
        System.out.println(d.matches("[a-zA-Z]\\d+")); // true
        d = "asdasd3424";
        System.out.println(d.matches("[a-zA-Z]\\d+")); // false, Так как несколько букв

        // изменим выражение на случай если перед цифрами идет какое-то количество английских букв. Добавим '+' после скобок
        System.out.println(d.matches("[a-zA-Z]+\\d+")); // true
        d = "sad232sdasd23123";
        System.out.println(d.matches("[a-zA-Z]+\\d+")); // false

        // Допустим в строке идут английские буквы, среди них цифра 3 или 1 , а затем какой-то набор букв
        d = "sdasdw3333sda111sada43242";
        System.out.println(d.matches("[a-zA-Z31]+\\d+")); // true

        // Необходимо выдавать true, если в строке не содержатся какие либо символы. К примеру если в строке нет
        // 'a','b', 'c' выдаем true

        String e = "hello";
        String e1 = "hallo"; // содержит символ 'a'
        System.out.println(e.matches("[^abc]+")); // true
        System.out.println(e1.matches("[^abc]+")); // false так как есть исключаемый символ 'a'. Специпльный символ
        // [^} исключает все символы находящиеся после него
        System.out.println(e.matches("[^a-z]")); // false. исключаем все символы от a - z

        // необходимо выполнить проверку на валидность написания URL
        String url = "https://www.google.com";
        String url2 = "http://www.yandex.ru";
        System.out.println(url.matches("https?://www\\..+\\.(com|ru)")); // Часть ".+" символизирует о том что после www.
        // идет название сайта, состоящего из любых символов. После ставим точку и выполняем проверку на домен (com или ru)
        System.out.println(url2.matches("https?://www\\..+\\.(com|ru)")); // true

        String f = "123";
        System.out.println(f.matches("\\d{2}")); // false. так в передаваемой строке три цифры

    }
}
