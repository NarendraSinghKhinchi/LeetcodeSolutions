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
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function(root) {
    var first = null ;
    var second = null ;
    var prev = null ;
    inorder(root);
    function inorder(root){
        if(root.left != null)inorder(root.left) ;
        if(prev != null){
            if(first == null && root.val <= prev.val){
                first = prev ;
                second = root ;
            }else if(root.val <= prev.val){
                second = root ;
            }
        }
        prev = root ;
        if(root.right != null)inorder(root.right) ;
    }
    let value = first.val ;
    first.val = second.val
    second.val = value ;
};