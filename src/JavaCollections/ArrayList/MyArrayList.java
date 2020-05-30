package JavaCollections.ArrayList;

import java.util.Arrays;

public class MyArrayList {
    private int capacity;
    private int size;
    private int[] arr;

    public MyArrayList() {
        this.capacity = 10;
        this.size = 0;
        this.arr = new int[capacity];
    }
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];

    }
    public int getSize() {
        return size;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void add(int value) {
        if (size < capacity) {
            arr[size] = value;
            size++;
        } else {
            capacity = capacity * 2;
            int arrNew[] = new int[capacity];
            int i = 0;
            for(int x: arr) {
                arrNew[i++] = x;
            }
            arr = arrNew;
            arr[size] = value;
            size++;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
