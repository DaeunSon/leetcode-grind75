class MinStack {

    Deque<Integer> deque = new ArrayDeque<>();
    Deque<Integer> min = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int value) {
        deque.push(value);
        if (min.isEmpty()) {
            min.push(value);
        }
        else {
            min.push(Math.min(value, min.peek())); //각 원소일때의 최솟값을 저장
        }
    }
    
    public void pop() {
        deque.pop();
        min.pop();
    }
    
    public int top() {
        return deque.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
