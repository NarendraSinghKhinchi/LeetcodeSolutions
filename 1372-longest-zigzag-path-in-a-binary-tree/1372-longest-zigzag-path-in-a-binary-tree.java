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
    public int longestZigZag(TreeNode root) {
      
        max = 0 ;
        longest(root , -1 , 0);
        return max ;
    }
    int max = 0 ;
    private void longest(TreeNode root , int dir , int len){
        if(root == null){
            return ;
        }
        max = Math.max(max , len);
        // 0 means left now you should go right // 1 means left
        if(dir == 0){
            longest(root.right , 1 , len+1);
            longest(root.left , 0 , 1);
        }else{
            longest(root.left , 0 , len+1);
            longest(root.right , 1 , 1);
        }
    }
}