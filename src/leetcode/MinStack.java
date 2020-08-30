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

//用两个栈实现，stack  minStack
//stack存放正常入栈出栈的数据
//minStack存放每次入栈后，stack中的最小值
//因为minStack栈顶元素已经是上次入栈的最小值，所以入栈时仅需要比较minStack栈顶的值与新入栈的值的大小，即可获取当次入栈时，stack的最小值
