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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();   
        TreeNode curr = root ;
        while(curr != null){
            TreeNode left = curr.left ;
            
            if(left == null){
                list.add(curr.val);
                curr = curr.right ;
            }else{
                TreeNode rightmost = get(left , curr);
                if(rightmost.right == null){// create thread 
                    list.add(curr.val);
                    rightmost.right = curr ;
                    curr = curr.left ;
                }else{ // destroy thread 
                    rightmost.right = null ;
                    curr = curr.right ;
                }
            }
        }
        return list ;
    }
    public TreeNode get(TreeNode left , TreeNode curr){
        while(left.right != null && left.right != curr)left = left.right ;
        return left ;
    }
}