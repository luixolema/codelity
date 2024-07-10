package leetcode;

import java.util.Stack;

class Node{
    Integer val;
    Integer previousMin;

    Node(Integer val, Integer previousMin){
        this.val = val;
        this.previousMin = previousMin;
    }
}

public class Min_Stack_155 {
    private final Stack<Node> stack;
    private Integer currentMin= null;

    public Min_Stack_155() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (this.stack.isEmpty()){
            this.stack.push(new Node(val, null));
            this.currentMin = val;
        }else{
            if (this.stack.size() == 1){
                this.stack.push(new Node(val, currentMin));
            }else{
                this.stack.push(new Node(val, Math.min(this.currentMin, this.stack.peek().previousMin)));
            }
            this.currentMin = Math.min(this.currentMin, val);
        }
    }

    public void pop() {
        Node extracted = this.stack.pop();
        this.currentMin = extracted.previousMin;
    }

    public int top() {
        return this.stack.peek().val;
    }

    public int getMin() {
        return currentMin;
    }
}
