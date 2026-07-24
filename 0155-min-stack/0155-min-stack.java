class MinStack {
    // stack
    Deque<Long> st;
    long min;
    
    public MinStack() {
        this.st = new ArrayDeque<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if(this.st.isEmpty()) {
            this.st.push((long)value);
            this.min = value;
            return;
        } 
        if(value < this.min) {
            // compute new value
            long newVal = (2L*value)-this.min;
            this.st.push(newVal);
            this.min = value;
            return;
        }
        this.st.push((long)value);
    }
    
    public void pop() {
        long raw = this.st.pop();
        if(raw < min) {
            long prevMin = (2L*this.min)-raw;
            this.min = (int)prevMin;
        }
    }
    
    public int top() {
        long peek = st.peek();
        return (int) (peek < min ? min : peek);
    }
    
    public int getMin() {
        return (int) this.min;
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