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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length ;
        return builder(inorder , postorder , 0 , n-1 , 0 , n-1) ;
    }
    public TreeNode builder(int[] inorder , int[] postorder , int posts , int poste , int ins , int ine){
        if(ins > ine)return null ;
        
        TreeNode node = new TreeNode(postorder[poste]) ;
        int idx = ine ;
        
        while(inorder[idx] != postorder[poste] ){
            idx-- ;
        }
        int close = ine - idx ;
        node.left = builder(inorder , postorder , posts , poste - close - 1 , ins , idx - 1 ) ;
        node.right = builder(inorder , postorder ,poste - close , poste - 1 , idx+1  , ine ) ;
        return node ;
    }
}










