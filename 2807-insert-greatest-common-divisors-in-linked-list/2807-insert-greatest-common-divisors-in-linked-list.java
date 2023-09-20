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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode node = head.next ;
        ListNode prev = head ;

        while(node != null){
            int gcd = gcd(node.val , prev.val);
            ListNode n = new ListNode(gcd);
            prev.next = n ;
            n.next = node ;
            prev = node ;
            node = node.next ;
        }
        return head ;
    }
    public int gcd(int a , int b){
        if(b == 0 )return a ;
        else return gcd(b , a%b);
    }
}