package leetcode;

/**
 * 设计循环双端队列
 * Created by xsg on 2020/8/1.
 */
public class MyCircularDeque {
    private int[] elements;
    private int capacity;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.elements = new int[k];
        this.size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.isFull()) return false;

        for (int i = this.size; i > 0; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[0] = value;
        this.size ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.isFull()) return false;

        this.elements[this.size ++] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.isEmpty()) return false;

        for (int i = 0; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.isEmpty()) return false;

        this.size --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (this.isEmpty()) return -1;

        return this.elements[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (this.isEmpty()) return -1;

        return this.elements[(this.size - 1)];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size <= 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size >= this.capacity;
    }
}
