package BookExercise.Chapter_10;

public class Exercise1022 {
    /*Отрезок в прямоугольной (декартовой) системе координат задается двумя парами чисел: xl, yl определяют положение
     (координаты) начала отрезка (точка А), а х2, у2 определяют положение (координаты) конца отрезка (точка В).
     Напишите класс, который генерирует и выводит на экран две пары
     случайных целых числа из диапазона от -30 до +30: первая пара - координаты точки А, вторая - координаты точки В.
     Класс должен определить (и вывести на экран соответствующую информацию):
     • длину отрезка;
     • округленную длину отрезка (но не больше истинного!);
     • угол (в градусах), который образует отрезок с осью Х;
     • какую ось пересекает отрезок, и пересекает ли он какую-либо ось вообще.*/
    public static void main(String[] args) {
        int x1 = -30 + (int) (Math.random() * 61);
        int y1 = -30 + (int) (Math.random() * 61);

        int x2 = -30 + (int) (Math.random() * 61);
        int y2 = -30 + (int) (Math.random() * 61);

        System.out.println(x1 + "  " + y1);
        System.out.println(x2 + "  " + y2);
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("Длина отрезка = %.2f\n", distance);
        System.out.println((int) distance);
        double cos = (double) (Math.abs(x2 - x1)) /  distance;
        double angle = Math.toDegrees(Math.acos(Math.abs(cos)));
        System.out.printf("Угол = %.2f \n", angle);
        if (x1 > 0 && x2 < 0 || x1 < 0 && x2 > 0) System.out.println("Отрезок пересекает ось X");
        if (y1 > 0 && y2 < 0 || x1 < 0 && y2 > 0) System.out.println("Отрезок пересекает ось Y");
        else System.out.println("Отрезок не пересекает оси");




    }
}
