//{ Driver Code Starts
//Initial Template for javascript

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let obj = new Solution();
        console.log(obj.setBits(n));
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number} n
 * @returns {number}
*/

class Solution {
    
    setBits(n)
    {
        //your code here
        let count = 0 ;
        for(let i = 0 ; i < 32 ; i++){
            const mask =( 1 << i) ;
            if((n & mask) > 0)count++ ;
        }
        return count ;
    }
}