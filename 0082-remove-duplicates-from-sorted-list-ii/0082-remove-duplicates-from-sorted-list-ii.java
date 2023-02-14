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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null ;
        ListNode curr = head ;
        ListNode dummy = new ListNode(-1) ;
        ListNode tail = dummy ;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                int val = curr.val ;
                while(curr != null && curr.val == val)curr = curr.next ;
            }else{
                tail.next = curr ;
                tail = curr ;
                if(curr != null ) curr = curr.next ;
            } 
        }
        if(curr != null){
            tail.next = curr ;
            tail = curr ;
        }
        tail.next = null ;
        return dummy.next ;
    }
}