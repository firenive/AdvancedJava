package JUnit.Lesson2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DLesson2Test {
    private final double EPS = 1e-9; // константа для точности
    private static Vector2DLesson2 vLesson2;
    private int count = 1;

    @BeforeClass
    public static void  createNewVector() { // Перед началом тестирования создаем новый объект тестируемого класса
        vLesson2 = new Vector2DLesson2();
        System.out.println("Создан новый объект");
    }
    @Before  // выполняем перед каждым тестом
    public void newTest() {
        System.out.println("Запущен тест № " + count);
        count+=1;
    }
    @Test
    public void newVectorShouldHaveZeroLength() {
        // action
        Assert.assertEquals(0, vLesson2.length(), EPS);

    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Assert.assertEquals(0, vLesson2.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Assert.assertEquals(0, vLesson2.getY(), EPS);
    }
}
