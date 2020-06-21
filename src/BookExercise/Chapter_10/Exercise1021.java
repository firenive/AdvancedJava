package BookExercise.Chapter_10;

public class Exercise1021 {
    /*Положение точки в прямоугольной (декартовой) системе координат определяется двумя числам: координатами Х и У.
     Напишите класс, который генерирует и выводит на экран два случайных целых числа из диапазона от-30 до +30.
     Класс должен определить (и вывести на экран соответствующую информацию):
     • в какой четверти расположена точка;
     • к какой из осей она ближе;Функции библиотеки Math. Работа со случайными числами 71
     • расстояние между началом координат и точкой;
     • округленное до целого (но - не больше истинного!) расстояние из редыдущего пункта;
     • угол (в градусах), который образует линия, соединяющая точку с началом координат, с осью Х.*/
    public static void main(String[] args) {
        int x = -30 + (int) (Math.random() * 61);
        int y = -30 + (int) (Math.random() * 61);
        System.out.println("Координата X: " + x +
                "; Координата Y: " + y);

        if (x > 0 && y >0) System.out.println("Первая четверть");
        else if (x < 0 && y >0) System.out.println("Вторая четверть");
        else if (x < 0 && y <0) System.out.println("Третья четверть");
        else if (x > 0 && y <0) System.out.println("Четвертая четверть");

        if (Math.abs(x) > Math.abs(y)) System.out.println("Точка ближе к оси x");
        if (Math.abs(x) < Math.abs(y)) System.out.println("Точка ближе к оси y");
        double distance = Math.sqrt(x * x + y * y);
        System.out.println("Расстояние между точкой и началом координат: " + distance);
        System.out.println("Округленное расстояние " + ((int) distance));
        double tan = Math.abs((double) y / x);
        double angle = Math.toDegrees(Math.atan(Math.abs(tan)));
        System.out.println(tan);
        System.out.println(angle);



    }
}
