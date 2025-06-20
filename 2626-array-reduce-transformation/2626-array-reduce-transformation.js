/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let num = init ;
    for(let i = 0 ; i < nums.length ; i++){
        num = fn(num , nums[i]);
    }
    return num ;
};