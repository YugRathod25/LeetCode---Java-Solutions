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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        if(len < k){
            return head;
        }
        // revese first k group of link list
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 1; i <= k; i++){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        // now remain list is solved by recusion 
        ListNode recursiveHead = reverseKGroup(curr, k);

        // joining fist list with recursion list
        head.next = recursiveHead;

        //list is reversed as per question 
        // now prev node will be our head of new linked list
        return prev;
    }
}