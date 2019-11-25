package src;

import java.util.Stack;

public class Solution9 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void  push(int node){
        stack1.push(node);
    }

    public int pop() {
        int result;
        if (stack2.empty()) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        result = stack2.pop();
        return result;
    }
}
