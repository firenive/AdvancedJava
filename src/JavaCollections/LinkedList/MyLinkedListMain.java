package JavaCollections.LinkedList;

public class MyLinkedListMain {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(6);
        System.out.println(linkedList);
        System.out.println(linkedList.get(0)); // 1
        System.out.println(linkedList.get(4)); // 6
        // System.out.println(linkedList.get(10)); // IllegalArgumentException
        linkedList.remove(4);
        System.out.println(linkedList); // [1, 2, 10, 11]
        linkedList.remove(1);
        System.out.println(linkedList);
    }
}
