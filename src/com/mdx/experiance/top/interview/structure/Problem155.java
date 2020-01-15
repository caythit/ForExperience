package com.mdx.experiance.top.interview.structure;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;

import java.util.Stack;

/**
 * 实现描述：
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * Example:
 * <p>
 * problem155 problem155 = new problem155();
 * problem155.push(-2);
 * problem155.push(0);
 * problem155.push(-3);
 * problem155.getMin();   --> Returns -3.
 * problem155.pop();
 * problem155.top();      --> Returns 0.
 * problem155.getMin();   --> Returns -2.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/4
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem155 {
    Stack<MinNode> stack;

    class MinNode {
        Integer val;
        Integer min;

        public MinNode(Integer val) {
            this.val = val;
        }
    }

    public Problem155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        MinNode minNode = new MinNode(x);

        if (!stack.isEmpty()) {
            Integer min = Math.min(x, stack.peek().min);
            minNode.min = min;
        } else {
            minNode.min = x;
        }
        stack.push(minNode);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek().val;
        }
        return -1;
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek().min;
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem155 problem155 = new Problem155();
        problem155.push(-2);
        problem155.push(0);
        problem155.push(-3);
        System.out.println(problem155.getMin());
        problem155.pop();
        System.out.println(problem155.top());
        System.out.println(problem155.getMin());
    }
}
