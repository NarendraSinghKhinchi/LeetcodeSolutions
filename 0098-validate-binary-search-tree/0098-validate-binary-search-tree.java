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
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true ;
        if(root.left == null && root.right == null)return true ;
        TreeNode curr = root ;
        TreeNode prev = null ;
        
        while(curr != null){
            TreeNode left = curr.left ;
            if(left == null){
                if(prev != null &&  curr.val <= prev.val )return false ;
                prev = curr ;
                curr = curr.right ;
            }else{
                TreeNode rightmost = get(left , curr) ;
                if(rightmost.right == null){
                    rightmost.right = curr ;
                    curr = curr.left ;
                }else{
                    rightmost.right = null ;
                    if(prev != null &&  curr.val <= prev.val )return false ;
                    prev = curr  ;
                    curr = curr.right ;
                }
            }
            
        }
        return true ;
    }
    public TreeNode get(TreeNode node , TreeNode curr){
        while(node.right != null && node.right != curr)node = node.right ;
        return node ;
    }
}