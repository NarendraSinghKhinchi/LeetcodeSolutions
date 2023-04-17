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
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0 ;
        return small(root , k);
    }
    int count ;
    public int small(TreeNode node , int k ){
        if(node == null)return -1 ;
        
        int left = small(node.left , k);
        if(left != -1)return left ;
        count += 1 ;
        if(count == k)return node.val ;
        int right = small(node.right , k);
        return right ;
    }
}