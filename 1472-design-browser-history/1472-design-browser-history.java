class BrowserHistory {
    
    Stack<String> q ;
    Stack<String> st ;
    public BrowserHistory(String homepage) {
        
        this.q = new Stack<>();
        this.st = new Stack<>();
        st.push(homepage);
    }
    
    public void visit(String url) {
        q = new Stack<>();
        st.push(url);
    }
    
    public String back(int steps) {
        while(steps-- > 0 && st.size() > 1){
            q.push(st.pop());
        }
        return st.peek();
    }
    
    public String forward(int steps) {
        while(steps-- > 0  && q.size() > 0){
            st.push(q.pop());
        }
        return st.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */