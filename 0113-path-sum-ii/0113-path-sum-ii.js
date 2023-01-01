/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
    var ans = [] ;
    
    mover(root , targetSum , []) ;
    function mover(root , targetSum , arr ){
        if(root == null)return ;
        if(root.left == null && root.right == null && root.val == targetSum){
            arr.push(root.val);
            ans.push([...arr]);
            arr.pop();
            return ;
        }
        arr.push(root.val) ;
       
        mover(root.left , targetSum-root.val , arr) ;
        // console.log("inner  ",arr);
        mover(root.right , targetSum-root.val , arr);
        arr.pop();
        // console.log(arr);
        
    }
    
    return ans; 
};