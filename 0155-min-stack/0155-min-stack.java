class MinStack {
    // stack
    Deque<Pair> st;
    
    public MinStack() {
        this.st = new ArrayDeque<>();
    }
    
    public void push(int value) {
        if(!this.st.isEmpty()) {
            int min = this.st.peek().min;
            if(min < value) this.st.push(new Pair(value, min));
            else this.st.push(new Pair(value, value));
        } else {
            this.st.push(new Pair(value, value));
        }
    }
    
    public void pop() {
        this.st.pop();
    }
    
    public int top() {
        return this.st.peek().value;
    }
    
    public int getMin() {
        return this.st.peek().min;
    }
}

class Pair {
    int value;
    int min;
    public Pair(int value, int min) {
        this.value = value;
        this.min = min;
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