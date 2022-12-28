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
        longest(root);
        return max ;
    }
    int max = 0 ;
    private Node longest(TreeNode root){
        if(root == null)return new Node(0,0) ;
        if(root.left == null && root.right == null)return new Node(1,1) ;
        
        Node left = longest(root.left);
        Node right = longest(root.right) ;
        int curr = Math.max(left.right , right.left) ;
        max = Math.max(max , curr) ;
        return new Node(left.right+1 , right.left+1) ;
    }
    private class Node{
        int left , right ;
        Node(int l , int r){
            this.left = l ;
            this.right = r ;
        }
    }
}