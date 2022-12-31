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
    public int maxProduct(TreeNode root) {
        this.total = totaler(root) ;
        this.max = 0l ;
        recurs(root) ;
        return (int) (max%mod) ;
    }
    long total = 0l ;
    long max = 0l ;
    int mod = (int)(1e9+7);
    public long recurs(TreeNode root){
        if(root == null)return 0 ;
        long left = recurs(root.left);
        long right = recurs(root.right);
        max = Math.max(max , (total - left) * left);
        max = Math.max(max , (total-right)*right) ;
        return left+ right + root.val ;
    }
    public int totaler(TreeNode root){
        if(root == null)return 0 ;
        return totaler(root.left) + totaler(root.right) + root.val ;
    }
}