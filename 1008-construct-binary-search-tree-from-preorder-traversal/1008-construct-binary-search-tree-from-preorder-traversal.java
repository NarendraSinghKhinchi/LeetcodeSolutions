/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstbuilder(preorder , 0 , preorder.length - 1) ;
    }
    public TreeNode bstbuilder(int[]preorder , int low , int hi){
        if(low > hi)return null ;
        if(low == hi){
            return new TreeNode(preorder[low]) ;
        }
        int idx = low+1 ;
        while(idx <= hi && preorder[idx] < preorder[low] )idx++ ;
        TreeNode node = new TreeNode(preorder[low]) ;
        
        node.left = bstbuilder(preorder ,low+1 ,idx-1) ;
        node.right = bstbuilder(preorder ,idx , hi ) ;
        return node ;
    }
}