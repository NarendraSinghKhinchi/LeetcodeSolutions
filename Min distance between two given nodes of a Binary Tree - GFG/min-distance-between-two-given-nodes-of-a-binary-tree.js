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

class Node
{
    constructor(x){
        this.data=x;
        this.left=null;
        this.right=null;
    }
}

function buildTree(str)
{
	// Corner Case
	if (str.length === 0 || str[0] == 'N')
		return null;

	// Creating vector of strings from input
	// string after spliting by space
	let ip = new Array();
    
    let ip_str = str.split(" ");
    
	for (let i=0;i<ip_str.length;i++)
		ip.push(ip_str[i]);

	// Create the root of the tree
    let root = new Node(parseInt(ip[0]));

	// Push the root to the queue
	let queue = new Array();
	queue.push(root);

	// Starting from the second element
	let i = 1;
	while (queue.length!==0 && i < ip.length) {

		// Get and remove the front of the queue
		let currNode = queue[0];
		queue.shift();

		// Get the current node's value from the string
		let currVal = ip[i];

		// If the left child is not null
		if (currVal != "N") {

			// Create the left child for the current node
			currNode.left = new Node(parseInt(currVal));

			// Push it to the queue
			queue.push(currNode.left);
		}

		// For the right child
		i++;
		if (i >= ip.length)
			break;
		currVal = ip[i];

		// If the right child is not null
		if (currVal != "N") {

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
    for(let i=0;i<t;i++)
    {
        let s_tree = readLine().trim();
        let [n1,n2] = readLine().split(" ").map((x) => parseInt(x));
        let root = buildTree(s_tree);
        let obj = new Solution();
        let res = obj.findDist(root,n1,n2);
		console.log(res);
    }
}
// } Driver Code Ends


//User function Template for javascript

/*
class Node
{
    constructor(x){
        this.data=x;
        this.left=null;
        this.right=null;
    }
}
*/

/**
 * @param {Node} root
 * @param {number} a
 * @param {number} b
 * @return {number}
*/
class Solution {
  	findDist(root,a,b){
  		//code here
  		var mlca = null ;
  		function lca(root , a , b){
  		    if(root == null)return false ;
  		    if(root.data === a && root.data === b){
  		        mlca = root ;
  		        return false ;
  		    }
  		    const left = lca(root.left , a ,b);
  		    const right = lca(root.right , a , b);
  		    if(mlca != null)return false ;
  		    if(left === true && right === true){
  		        mlca = root ;
  		        return false ;
  		    }
  		    if(left === true && (root.data === a || root.data === b)){
  		        mlca = root ;
  		        return false ;
  		    }
  		    if(right === true && (root.data === a || root.data === b)){
  		        mlca = root ;
  		        return false ;
  		    }
  		    if(left === true || right === true || root.data === a || root.data === b)return true ;
  		    return false ;
  		}
  		lca(root , a , b);
  		// console.log(mlca);
  		function dist(root , target){
  		    if(root == null)return -1 ;
  		    if(root.data == target)return 0 ;
  		    const left = dist(root.left , target);
  		    if(left != -1)return left+1 ;
  		    const right = dist(root.right , target);
  		    if(right != -1)return right+1 ;
  		    return -1 ;
  		}
  		const first = dist(mlca , a);
  		const second = dist(mlca , b);
  		return first+second ;
  	}
}