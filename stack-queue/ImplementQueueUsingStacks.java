class MyQueue {

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();


    //2개의 스택을 이용해서 선입선출 큐를 구현해라

    public MyQueue() {

    }

    public void move(){
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                int t = stack1.pop();
                stack2.push(t);
            }
        }
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        move();
        return stack2.pop();
    }
    
    public int peek() {
        move();
        return stack2.peek();
    }
    
    public boolean empty() {
        move();
        return stack2.isEmpty();
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
