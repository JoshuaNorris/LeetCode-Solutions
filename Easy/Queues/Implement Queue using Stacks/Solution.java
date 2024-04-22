class MyQueue {


	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        checkStack2();
        return stack2.pop();
    }
    
    public int peek() {
        checkStack2();
        int temp = stack2.pop();
        stack2.push(temp);
        return temp;
    }
    
    public boolean empty() {
        if (stack1.empty() && stack2.empty()) {
            return true;
        }
        return false;
    }

    private void checkStack2() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */