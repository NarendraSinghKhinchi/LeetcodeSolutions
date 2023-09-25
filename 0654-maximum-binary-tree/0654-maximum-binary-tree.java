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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return cons(nums , 0 , nums.length -1 );
    }
    public TreeNode cons(int []nums ,int left , int right){
        if(right < left)return null ;
        int maxi = maxi(nums, left , right);
        TreeNode node = new TreeNode(nums[maxi]);
        node.left = cons(nums , left , maxi-1);
        node.right = cons(nums , maxi+1 , right);
        return node ;
    }
    public int maxi(int[]nums , int left , int right){
        int maxi = left ;
        while(left <= right){
            if(nums[left] > nums[maxi]){
                 maxi = left ;
            }
            left++ ;
        }
        return maxi ;
    }
}