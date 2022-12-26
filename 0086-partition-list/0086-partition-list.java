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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1) ;
        ListNode head2 = new ListNode(-2) ;
        ListNode tail1 = head1 ;
        ListNode tail2 = head2 ;
        ListNode curr = head ;
        while(curr != null){
            ListNode next = curr.next ;
            if(curr.val < x){
                tail1.next = curr ;
                tail1 = curr ;
                curr.next = null ;
            }else{
                tail2.next = curr ;
                tail2 = curr ;
                curr.next = null ;
            }
            curr = next ;
        }
        
        tail1.next = head2.next ;
        head1 = head1.next ;
        return head1 ;
    }
}