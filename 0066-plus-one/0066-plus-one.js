/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    digits.reverse();
    let carry = 1 ;
    let i = 0 ;
    while(i < digits.length){
        let sum = digits[i] + carry ;
        carry = Math.floor(sum/10) ;
        digits[i] = sum%10 ;
        if(carry == 0)break ;
        i++ ;
    }
    
    if(carry !== 0)digits.push(carry) ;
    return digits.reverse();
};