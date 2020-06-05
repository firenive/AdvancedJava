package JavaCollections.Stack;

import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        /* Данный класс является противоположностью Queue. Элемент который добавили последним находится в начале
        * стэка. last in, first out. Коллекция нужна если нужно часто получать последний элемент*/
        stack.push(5); // добавление элемента в стэк
        stack.push(3);
        stack.push(1);

        System.out.println(stack.pop()); // выводит последний добавленный в стэк элемент, при этом извлекая его из Stack OUT: 1
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 5
       // System.out.println(stack.pop()); // Exception in thread "main" java.util.EmptyStackException

        Stack<String> testStack = new Stack<>();
        testStack.push("One");
        testStack.push("Two");
        testStack.push("Four");
        // peek() выводит последний добавленный в стэк элемент не извлекая его
        System.out.println(testStack.peek()); // Four
        System.out.println(testStack.peek()); // Four
        System.out.println(testStack.pop()); // Four элемент извлекается
        System.out.println(testStack.peek()); // Two

        testStack.push("Ten");
        testStack.push("Nine");
        System.out.println("---------------------------------");

        while (!testStack.empty()) {
            System.out.println(testStack.pop());
        }

    }
}
