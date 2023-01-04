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
 * @param {number} start
 * @return {number}
 */
var amountOfTime = function(root, start) {
    let max = 0 ;
    function maxdepth(root , k){
        
        if(root === null)return ;
        max = Math.max(max , k) ;

        maxdepth(root.left , k+1);
        maxdepth(root.right , k+1) ;
    }
    function traveller(root , start){
        if(root === null)return -1 ;
        if(root.val === start){
            maxdepth(root , 0) ;
            return 1 ;
        }
        const left = traveller(root.left , start) ;
        if(left != -1){
            maxdepth(root.right , left+1) ;
            max = Math.max(max , left);
            return left+1 ;
        }
        const right = traveller(root.right , start) ;
        if(right != -1){
            maxdepth(root.left ,right+1 ) ;
            max = Math.max(max , right);
            return right+1 ;
        }
        return -1 ;
    }
    traveller(root , start);
    return max ;
};