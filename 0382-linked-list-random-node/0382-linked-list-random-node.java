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
    ListNode head ;
    int size = 0 ;
    public Solution(ListNode head) {
        this.head = head ;
        ListNode temp = head ;
        while(temp != null){
            this.size++ ;
            temp = temp.next ;
        }
    }
    public int get(int idx){
        ListNode temp = head ;
        while(temp != null){
            if(idx == 0)return temp.val ;
            idx-- ;
            temp = temp.next ;
        }
        return -1 ;
    }
    public int getRandom() {
        int idx = (int) (Math.random() * this.size) ;
        
        return get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */