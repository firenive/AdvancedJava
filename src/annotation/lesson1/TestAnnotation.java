package annotation.lesson1;

import junit.framework.Test;

@MyAnnotation // Обычно одна аннотации применяются к определенным сущностям. Например аннотация только для классов,
// Аннотация только для переменных и т.д.
public class TestAnnotation {
    @MyAnnotation
    private String name; // применяем созданную аннотацию для классов, переменных, методов, конструктора

    @MyAnnotation
    public TestAnnotation() {
    }
    @MyAnnotation
    public void test(@MyAnnotation int value) {
        @MyAnnotation String localVar = "Hello";
    }
    @MyAnnotation
    public static void main(@MyAnnotation String[] args) {

    }
}
