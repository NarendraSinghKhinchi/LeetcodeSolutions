/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
    
    points.sort( (a,b) => a[1]-b[1]) ;
    let ans = 0 ;
    // console.log(points);
    for(let i = 0 ; i < points.length ; i++){
        ans++ ;
        let j = i ;
        while(i < points.length-1 && points[j][1] >= points[i+1][0])i++ ;
        // console.log(i);
    }
    return ans ;
};