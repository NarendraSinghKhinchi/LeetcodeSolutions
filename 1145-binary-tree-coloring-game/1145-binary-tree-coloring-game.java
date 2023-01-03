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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        TreeNode target = finder(root , x);
        int left = counter(target.left);
        int right = counter(target.right);
        int parent = n - (left + right) - 1 ;
        if(parent > left+right+1)return true ;
        if(left > parent+right+1)return true ;
        if(right > left+parent+1)return true ;
        return false ;
    }
    public int counter(TreeNode root){
        if(root == null)return 0 ;
        return counter(root.left) + counter(root.right) + 1 ;
    }
    public TreeNode finder(TreeNode root , int x){
        if(root == null)return null ;
        if(root.val == x)return root ;
        
        TreeNode left = finder(root.left , x);
        if(left != null)return left ;
        TreeNode right = finder(root.right , x);
        
        return right ;
    }
}