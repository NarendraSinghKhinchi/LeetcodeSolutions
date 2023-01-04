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

class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function buildTree(str){
   // Corner Case
   if(str.length === 0 || str[0] === "N")
       return null;

   // Create the root of the tree
   let root = new Node(parseInt(str[0]));

   // Push the root to the queue
   let queue = [];
   let start = 0;
   queue.push(root);

   // Starting from the second element
   let i = 1;
   while(queue.length !== start && i < str.length) {

       // Get and remove the front of the queue
       let currNode = queue[start];
       start++;

       // Get the current node's value from the string
       let currVal = str[i];

       // If the left child is not null
       if(currVal !== "N") {

           // Create the left child for the current node
           currNode.left = new Node(parseInt(currVal));

           // Push it to the queue
           queue.push(currNode.left);
       }

       // For the right child
       i++;
       if(i >= str.length)
           break;
       currVal = str[i];

       // If the right child is not null
       if(currVal !== "N") {

           // Create the right child for the current node
           currNode.right = new Node(parseInt(currVal));

           // Push it to the queue
           queue.push(currNode.right);
       }
       i++;
   }

   return root;
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let input_ar0 = readLine().split(' ').map(x=>parseInt(x));
        let a = parseInt(input_ar0[0]);
        let b = parseInt(input_ar0[1]);
        let input_ar1 = readLine().split(' ');
        let root = buildTree(input_ar1);
        let obj = new Solution();
        let res = obj.lca(root, a, b);
        console.log(res.data);
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Node} root
 * @param {number} n1
 * @param {number} n2
 * @returns {Node}
*/

/*
class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    //Function to return the lowest common ancestor in a Binary Tree.
    lca(root, n1, n2)
    {
        //your code here
        var mlca = null ;
        function traveller(root , p , q){
            if(root == null)return false ;
            
            const left= traveller(root.left , p , q);
            const right = traveller(root.right , p , q);
            
            if(mlca != null)return false ;
            if(left === true && right === true){
                mlca = root ;
                return false ;
            }
            if(left === true &&( root.data === p || root.data === q )){
                mlca = root ;
                return false ;
            }
            if(right === true && ( root.data === p || root.data === q )){
                mlca = root ;
                return false ;
            }
            if(left === true || right === true || root.data === p || root.data === q)return true ;
            return false ;
        }
        traveller(root ,  n1 , n2) ;
        
        return mlca ;
    }
}