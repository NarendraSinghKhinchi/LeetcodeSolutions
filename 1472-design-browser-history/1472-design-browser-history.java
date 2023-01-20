class BrowserHistory {
    
    Deque<String> his;
    Deque<String> forw ;
    public BrowserHistory(String homepage) {
        his = new ArrayDeque<>(); 
        his.push(homepage);
        forw = new ArrayDeque<>() ;
    }
    
    public void visit(String url) {
        forw.clear();
        his.push(url);
    }
    
    public String back(int steps) {
        while(steps >= 1 && his.size() > 1){
            forw.push(his.pop());
            steps-- ;
        }
        return his.peek();
    }
    
    public String forward(int steps) {
        while(steps >= 1 && forw.isEmpty() == false){
            his.push(forw.pop());
            steps-- ;
        }
        return his.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */