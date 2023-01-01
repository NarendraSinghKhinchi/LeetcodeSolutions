
var StockSpanner = function() {
    this.Stack = [] ;
};

/** 
 * @param {number} price
 * @return {number}
 */
StockSpanner.prototype.next = function(price) {
    
    const Stack = this.Stack ;
    let count = 1 ;
    for(let i = Stack.length - 1 ; i >= 0 ; i--){
        if(Stack[i] > price)break ;
        count += 1 ;
    }
    // console.log(Stack) ;
    Stack.push(price);
    return count ;
};

/** 
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = new StockSpanner()
 * var param_1 = obj.next(price)
 */