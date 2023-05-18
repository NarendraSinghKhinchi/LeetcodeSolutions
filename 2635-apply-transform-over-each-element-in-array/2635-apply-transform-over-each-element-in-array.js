/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const arr2 = arr.map((ele , idx)=>{
       return fn(ele , idx);
    });
    return arr2 ;
};