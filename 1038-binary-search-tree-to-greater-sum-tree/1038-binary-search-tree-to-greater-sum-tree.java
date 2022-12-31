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
    public TreeNode bstToGst(TreeNode root) {
        this.sumUp = 0 ;
        postorder(root);
        return root ;
    }
    int sumUp ;
    public void postorder(TreeNode root ){
        if(root == null)return  ;
        postorder(root.right);
        sumUp += root.val ;
        root.val = sumUp ;
        postorder(root.left);
    }
}