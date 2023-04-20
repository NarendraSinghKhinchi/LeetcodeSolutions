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
    public int widthOfBinaryTree(TreeNode root) {
        this.list = new ArrayList<>();
        this.max = 1 ;
        travel(root , 0 , 1);
        return max ;
    }
    ArrayList<Integer> list ;
    int max ;
    public void travel(TreeNode node , int idx , int level){
        if(node == null)return ;
        if(list.size() < level){
            list.add(idx);
        }else{
            int width = idx - list.get(level-1) + 1 ;
            max = Math.max(width , max);
        }
        travel(node.left , 2*idx+1 , level+1);
        travel(node.right , 2*idx+2 , level+1);
        
    }
}