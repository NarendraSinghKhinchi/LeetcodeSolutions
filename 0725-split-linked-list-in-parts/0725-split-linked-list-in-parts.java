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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k] ;
        int n = 1 ;
        ListNode curr = head ;
        while(curr != null){
            curr = curr.next ;
            n++ ;
        }
        int div = n / k ;
        int rem = n % k ;
        curr = head ;
        int i = 0 ;
        while(curr != null && i < k){
            int j = 1 ;
            ListNode tail = null ;
            while(curr != null && j <= div ){
                ListNode next = curr.next ;
                if(arr[i] == null){
                    arr[i] = curr ;
                    tail = curr ;
                }else{
                    tail.next = curr ;
                    tail = curr ;
                }
                curr.next = null ;
                curr = next ;
                j++ ;
            }
            if(i+1 < rem && curr != null){
                ListNode next = curr.next ;
                if(arr[i] == null){
                    arr[i] = curr ;
                    tail = curr ;
                }else{
                    tail.next = curr ;
                    tail = curr ;
                }
                curr.next = null ;
                curr = next ;
            }
            i++ ;
        }
        return arr ;
    }
}