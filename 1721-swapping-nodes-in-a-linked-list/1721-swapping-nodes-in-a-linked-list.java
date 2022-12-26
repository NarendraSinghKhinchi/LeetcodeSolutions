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
    public ListNode swapNodes(ListNode head, int k) {
        int i = 1 ;
        ListNode temp1 = null ;
        ListNode khead = head ;
        while(i < k){
            i++ ;
            khead = khead.next ;
        }
        
        ListNode curr = head ;
        temp1 = khead ;
        while(khead.next != null){
            curr = curr.next ;
            khead = khead.next ;
        }
        int te = temp1.val ;
        temp1.val = curr.val ;
        curr.val = te ;
        return head ;
    }
}