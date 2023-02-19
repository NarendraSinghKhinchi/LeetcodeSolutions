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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)return list ;
        int level = 0 ;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.isEmpty() == false){
            int size = q.size() ;
            List<Integer> curr = new ArrayList<>();
            for(int i = 1 ; i <= size ; i++){
                TreeNode rem = q.remove() ;
                curr.add(rem.val);
                if(rem.left != null)q.add(rem.left) ;
                if(rem.right != null)q.add(rem.right);
            }
            list.add(curr) ;
            if(level % 2 != 0)Collections.reverse(curr);
            level++ ;
        }
        return list ;
    }
}