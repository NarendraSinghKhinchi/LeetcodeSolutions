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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)return null ;
        return merger(lists , 0 , lists.length - 1);
    }
    public ListNode merger(ListNode [] lists , int left , int right ){
        if(left == right)return lists[left] ;
        
        int mid = (left+right)/2 ;
        ListNode start = merger(lists , left , mid);
        ListNode end = merger(lists , mid+1 , right);
        return merge(start , end);
    }
    public ListNode merge(ListNode head1 , ListNode head2){
        if(head1 == null)return head2 ;
        if(head2 == null)return head1 ;
        if(head1 == null && head2 == null)return null ;
        if(head1.val < head2.val){
            head1.next= merge(head1.next , head2);
            return head1 ;
        }
        head2.next = merge(head1 , head2.next );
        return head2 ;
    }
}