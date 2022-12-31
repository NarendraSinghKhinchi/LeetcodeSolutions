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
    public int sumNumbers(TreeNode root) {
        this.total = 0 ;
        summer(root , 0) ;
        return total ;
    }
    int total = 0 ;
    public void summer(TreeNode root , int num){
        if(root == null )return ;
        num = num * 10 + root.val ;
        if(root.left == null && root.right == null){
            total += num ;
            return ;
        }
        summer(root.left , num);
        summer(root.right , num);
    }
}