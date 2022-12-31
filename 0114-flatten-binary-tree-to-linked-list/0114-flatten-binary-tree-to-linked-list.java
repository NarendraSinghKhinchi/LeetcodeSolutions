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
    public void flatten(TreeNode root) {
        flatter(root);
    }
    public TreeNode flatter(TreeNode root){
        if(root == null)return null ;
        if(root.left == null && root.right == null)return root ;
        
        TreeNode lefthead = flatter(root.left);
        TreeNode righthead = flatter(root.right) ;
        root.left = null ;
        if(lefthead == null){
            root.right = righthead ;
        }else{
            TreeNode leftTail = tailer(lefthead) ;
            leftTail.right = righthead ;
            root.right = lefthead ;
        }
        return root ;
    }
    public TreeNode tailer(TreeNode root){
        while(root.right != null)root = root.right ;
        return root ;
    }
}