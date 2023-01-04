/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} target
 * @param {number} k
 * @return {number[]}
 */
var distanceK = function(root, target, k) {
    const ans = [] ;
    function traveller(root , target , k){
        if(root == null)return -1 ;
        if(root === target ){
            kdown(root , k);
            return k-1 ;
        }
        const left = traveller(root.left , target , k);
        if(left == 0){
            kdown(root , left);
            return -1 ;
        }else if(left > 0){
            kdown(root.right , left-1);
            return left-1 ;
        }
        const right = traveller(root.right , target , k);
        if(right == 0){
            kdown(root , right);
        }else if(right > 0){
            kdown(root.left , right-1);
            return right-1 ;
        }
        return -1 ;
    }
    function kdown(root , k){
        if(root == null)return ;
        if(k == 0){
            ans.push(root.val) ;
            return ;
        }
        kdown(root.left , k-1);
        kdown(root.right , k-1);
    }
    traveller(root ,target ,k);
    return ans ;
};