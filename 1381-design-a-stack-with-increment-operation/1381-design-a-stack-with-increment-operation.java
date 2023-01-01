class CustomStack {

    public CustomStack(int maxSize) {
       this.top = -1;
        this.arr = new int[maxSize] ;
    }
    int arr[] ;
    int top ;
    public void push(int x) {
        if(top+1 < arr.length){
            arr[++top] = x ;
            // top++ ;
        }
    }
    
    public int pop() {
        if(top >= 0){
            return arr[top--] ;
        }
        return -1 ;
    }
    
    public void increment(int k, int val) {
        for(int i = 0 ; i < k && i < arr.length ;i++){
            arr[i] += val ;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */