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
    public int minDiffInBST(TreeNode root) {
        this.min = Integer.MAX_VALUE ;
        this.prev = null ;
        differ(root);
        return min ;
    }
    static int min  ;
    TreeNode prev ;
    public void differ(TreeNode root){
        if(root == null)return ;
        
        differ(root.left);
        if(prev != null){
            min = Math.min(min , root.val - prev.val);
        }
        prev = root ;
        differ(root.right);
        
    }
}