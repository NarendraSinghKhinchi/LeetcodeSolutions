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
        int max_width = 1 ;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root , 0)) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            int first = 0 ;
            int last = 0 ;
            for(int i = 1 ; i <= size  ; i++){
                Pair rem = q.remove() ;
                if(i == 1){
                   first = rem.idx ;
                   last = rem.idx ;
                }
                if(i == size){
                    last = rem.idx;
                }
                 
                if(rem.node.left != null)q.add(new Pair(rem.node.left , rem.idx*2+1)) ;
                if(rem.node.right != null)q.add(new Pair(rem.node.right , rem.idx*2+2)) ;
            }
            
            int curr_width = last - first + 1 ;
            max_width = Math.max(max_width , curr_width);

            
        }
        return max_width ;
    }
    class Pair{
        int idx ;
        TreeNode node ;
        Pair(TreeNode node , int idx){
            this.node = node ;
            this.idx = idx ;
        }
    }
}
