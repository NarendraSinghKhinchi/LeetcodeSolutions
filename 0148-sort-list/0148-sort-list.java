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
    public ListNode sortList(ListNode head) {
        return quick(head)[0] ;
    }
    public ListNode[] quick(ListNode head){
        if(head == null || head.next == null)return new ListNode[]{head , head} ;                 
        int len = length(head);
        int pivotindex = len / 2;
        
        ListNode[] seg = segregate(head , pivotindex);
        ListNode []left = quick(seg[0]);
        ListNode []right = quick(seg[2]);
        return merge(left , right , seg[1]) ;
    }
    public ListNode[] merge(ListNode []left , ListNode []right , ListNode pivotnode ){
        
        ListNode head = null ;
        ListNode tail = null ;
        if(left[0] != null && right[0] != null){
            head = left[0] ;
            tail = right[1] ;
            left[1].next = pivotnode ;
            pivotnode.next = right[0] ;
        }else if(left[0] != null){
            head = left[0] ;
            tail = pivotnode ;
            left[1].next = pivotnode ;
        }else if(right[0] != null){
            head = pivotnode ;
            pivotnode.next = right[0] ;
            tail = right[1] ;
        }else{
            head = pivotnode ;
            tail = pivotnode ;
        }
        return new ListNode[]{head , tail} ;
    }
    public int length(ListNode node){
        int l = 0 ;
        while(node != null){
            node = node.next ;
            l++ ;
        }
        return l ;
    }
    public ListNode[] segregate(ListNode head , int pivotIndex){
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        
        ListNode curr = head , sp = small , lp = large , pivotnode = head ;
        while(pivotIndex-- > 0)pivotnode = pivotnode.next ;
        
        while(curr != null){
            if(curr != pivotnode){
                if(curr.val <= pivotnode.val){
                    sp.next = curr ;
                    sp = curr ;
                }else{
                    lp.next = curr ;
                    lp = curr ;
                }
            }
            curr = curr.next ;
        }
        sp.next = null ;
        lp.next = null ;
        pivotnode.next = null ;
        
        return new ListNode[]{small.next , pivotnode , large.next};
        
    }
}