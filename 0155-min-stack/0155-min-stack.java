class MinStack {
    Stack<Integer> st ;
    Stack<Integer> mi ;
    public MinStack() {
        this.st = new Stack<>();
        this.mi = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(mi.isEmpty() || val < mi.peek() ){
            mi.push(val);
        }else {
            mi.push(mi.peek()) ;
        }
    }
    
    public void pop() {
        mi.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    } 
    
    public int getMin() {
        return mi.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */