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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightView(list , root , 1) ;
        return list ;
    }
    public void rightView(List<Integer> list , TreeNode node , int level){
        if(node == null)return ;
        
        if(list.size() < level){
            list.add(node.val);
        }
        rightView(list , node.right , level+1);
        rightView(list , node.left , level+1);
    }
}