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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return head ;
        int len = len(head);
        k = k % len ;
        if(k == 0 )return head ;
        int steps = len - k ;
        ListNode newhead = head ; 
        while(steps-- >= 1){
            ListNode t= newhead.next ;
            if(steps == 0){
                newhead.next = null ;
            }
            newhead = t ;
        }
        
        ListNode tail = newhead ;
        
        while(tail.next != null)tail = tail.next ;
        tail.next = head ;
        return newhead ;
    }
    public int len(ListNode node){
        int i = 0 ;
        while(node != null){
            node = node .next ;
            i++;
        }
        return i ;
    }
}