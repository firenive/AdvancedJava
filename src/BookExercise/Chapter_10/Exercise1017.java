package BookExercise.Chapter_10;

public class Exercise1017 {
    public static void main(String[] args) {
        /*Напишите класс, который генерирует длины сторон катетов прямоугольного треугольника так, чтобы длина катета не превышала
        10.5 см. Класс должен подсчитать длину гипотенузы этого треугольника, его площадь и периметр и вывести их на экран.
        Затем эти вычисленные значения следует округлить и вывести результат на экран в отдельной строке вместе с
        соответствующим текстовым сообщением.*/
        double katet = 1 + (Math.random() * 9.5);
        double katet2 = 1 + (Math.random() * 9.5);

        System.out.println("Катет  " + katet);
        System.out.println("Катет2  " + katet2);
        double hyp = Math.sqrt((Math.pow(katet, 2) + Math.pow(katet2, 2)));
        double area =  (katet * katet2) * 0.5;
        double perim = katet + katet2 + hyp;
        System.out.printf("Гипотенуза треугольника = %.2f" , hyp);
        System.out.printf("\nПлощадь треугольника = %.2f" , area);
        System.out.printf("\nПериметр треугольника = %.2f" , perim);

    }
}

