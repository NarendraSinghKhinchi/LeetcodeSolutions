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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length ;
        return builder(preorder , postorder , 0 , n-1 , 0 , n-1);
    } 
    public TreeNode builder(int []preorder , int[]postorder , int pres , int pree , int posts , int poste){
        
        if(pres > pree )return null ;
        if(pres == pree){
            return new TreeNode(preorder[pres]) ;
        }
        int idx = posts ;
        for( ; idx <= poste ; ){
            if(postorder[idx] == preorder[pres + 1])break ;
            idx++ ;
        }
        int close = idx - posts ;
        TreeNode node = new TreeNode(preorder[pres]) ;
        
        node.left = builder(preorder , postorder , pres+1 , pres + close + 1 , posts , idx) ; 
        node.right = builder(preorder , postorder , pres + close + 2 , pree , idx + 1 , poste - 1) ;
       
        
        return node ;
        
    }
}