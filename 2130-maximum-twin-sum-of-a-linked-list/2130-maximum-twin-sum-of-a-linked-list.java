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
class Solution {
    public int pairSum(ListNode head) {
        
        ListNode slow = head ;
        ListNode fast = head.next ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        ListNode mid = slow ;
        slow = rev(mid.next);
        mid.next = null ;
        
        int max = 0 ;
        while(head != null){
            max = Math.max(max , head.val+slow.val);
            head = head.next ;
            slow = slow.next ;
        }
        
        return max ;
    }
    public ListNode rev(ListNode head){
        if(head == null || head.next == null)return head ;
        
        ListNode newhead = rev(head.next);
        head.next.next = head ;
        return newhead ;
    }
}