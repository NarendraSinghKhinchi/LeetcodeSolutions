/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        
        return sorted(head , null) ;
    }
    public TreeNode sorted(ListNode head , ListNode tail){
        if(head == null)return null ;
        if(head.next == null)return new TreeNode(head.val) ;
        ListNode mid = head ;
        ListNode fast = head ;
        ListNode prev = null ;
        while(fast != null && fast.next != null){
            prev = mid ;
            mid = mid.next ;
            fast = fast.next.next ;
        }
        // System.out.println(mid.val);
        TreeNode root = new TreeNode(mid.val) ;
        ListNode next = mid.next ;
        mid.next = null ;
        if(prev != null) prev.next = null ;
        root.left = sorted(head , null) ;
        root.right = sorted(next , null) ;
        
        return root ;
    }
}





