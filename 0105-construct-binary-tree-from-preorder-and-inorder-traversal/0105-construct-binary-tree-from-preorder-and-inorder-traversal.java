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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length ;
        return buildTree2(preorder , inorder , 0 , n-1 , 0 , n-1);
    }
    public TreeNode buildTree2(int[] preorder, int[] inorder , int psi , int pei , int isi , int iei) {
        if(isi > iei)return null ;
        int idx = isi ;
        while(inorder[idx] != preorder[psi])idx++ ;
        int close = idx - isi ;
        TreeNode node = new TreeNode(preorder[psi]) ;
        node.left = buildTree2(preorder , inorder , psi+1 , psi + close , isi , idx-1) ;
        node.right = buildTree2(preorder , inorder , psi + close+1 , pei , idx+1 , iei) ;
        return node ;
    }
}