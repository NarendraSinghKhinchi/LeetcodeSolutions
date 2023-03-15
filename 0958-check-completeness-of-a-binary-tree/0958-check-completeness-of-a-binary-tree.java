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
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean nullfound = false ;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode rem = q.remove();
                
                
                
                if(rem.left != null){
                    if(nullfound)return false ;
                    q.add(rem.left);
                }else if(rem.left == null)nullfound = true ;
                if(rem.right != null){
                    if(nullfound)return false ;
                    q.add(rem.right);
                }else if(rem.right == null)nullfound  = true ;
            }
        }
        
        return true  ;
    }
}