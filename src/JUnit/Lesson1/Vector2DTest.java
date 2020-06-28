package JUnit.Lesson1;

import org.junit.Assert;
import org.junit.Test;

public class Vector2DTest {

    @Test
    public void newVectorShouldHaveZeroLength() {
        // action
        Vector2D v1 = new Vector2D();
        // assertion (Необходимо проверить что новый созданный вектор не имеет длины). Для этого сравним его длину с нулем
        Assert.assertEquals(0, v1.length(), 1e-9);
        /* Первый аргумент это ожидаемая величина. Второй аргумент это фактический результат (сравнивается с ожидаемым)
         третий аргумент это точность. 2 числа будут считаться равными если они отличаются не более чем на 0.0000000001
         (1e-9) */
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Vector2D v1 = new Vector2D();
        Assert.assertEquals(0, v1.getX(), 1e-9);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Vector2D v1 = new Vector2D();
        Assert.assertEquals(0, v1.getY(), 1e-9);
    }
}
