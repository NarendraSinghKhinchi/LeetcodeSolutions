/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a,b)=> {
        if(a[0] != b[0]) return a[0]-b[0] ;
        return a[1]-b[1] ;
    })
    
    const ans = [] ;
    ans.push(intervals[0]); 
    for(let i = 1 ; i < intervals.length; i++){
        const curr = intervals[i] ;
        const last = ans[ans.length-1] ;
        
        if(last[1] >= curr[0] ){
           last[1] = Math.max(curr[1], last[1]) ;
        }else {
            ans.push(intervals[i]) ;
        }
    }
    
    return ans ;
};