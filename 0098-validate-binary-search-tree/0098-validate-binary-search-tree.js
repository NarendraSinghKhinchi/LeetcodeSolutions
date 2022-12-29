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
 * @return {boolean}
 */
var isValidBST = function(root) {
    if(root == null)return true ;
    if(root.left == null && root.right == null)return true ;
    var curr = root ;
    var prev = null;
    while(curr != null){
        let left = curr.left ;
        if(left == null){
            if(prev != null && curr.val <= prev.val)return false ;
            prev = curr  ;
            curr = curr.right ;
        }else{
            let rightmost = get(left , curr) ;
            if(rightmost.right == null){
                rightmost.right = curr ;
                curr = curr.left ;
            }else{
                rightmost.right = null ;
                if(prev != null && curr.val <= prev.val)return false ;
                prev = curr  ;
                curr = curr.right ;
            }
        }
    }
    function get(left , curr){
        while(left.right != null && left.right != curr)left = left.right ;
        return left ;
    }
    return true ;
};