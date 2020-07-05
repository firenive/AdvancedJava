package JUnit.Lesson2;

public class Vector2DLesson2 {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double length() {
        return Math.sqrt(x *x + y* y);

    }
}
