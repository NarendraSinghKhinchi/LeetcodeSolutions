/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    
    var lca = null ;
    function traveller(root , p , q){
        if(root == null)return false ;
        
        const left= traveller(root.left , p , q);
        const right = traveller(root.right , p , q);
        
        if(lca != null)return false ;
        if(left === true && right === true){
            lca = root ;
            return false ;
        }
        if(left === true &&( root === p || root === q )){
            lca = root ;
            return false ;
        }
        if(right === true && ( root === p || root === q )){
            lca = root ;
            return false ;
        }
        if(left === true || right === true || root === p || root === q)return true ;
        return false ;
    }
    traveller(root ,  p , q) ;
    
    return lca ;
};