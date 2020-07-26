package leetcode;

import java.util.Stack;

/**
 * 最小栈(https://leetcode-cn.com/problems/min-stack/)
 * Created by xsg on 2020/7/26.
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        int min = x;
        if (!minStack.isEmpty()) {
            min = Math.min(min, minStack.peek());
        }
        minStack.push(min);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        int res = stack.peek();
        return res;
    }

    public int getMin() {
        if (stack.isEmpty()) return -1;
        int res = minStack.peek();
        return res;
    }
}
