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
    public static ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        // reverse ll
        head = reverseLL(head);
        // math part

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode temp = head;
        int carry = 0;
        while(temp != null){
            int value = temp.val;
            int sum = value + value + carry;
            int digit = sum % 10;
            // add this digit to our new list
            curr.next = new ListNode(digit);
            curr = curr.next;
            // handle carry
            carry = sum/10;
            temp = temp.next;
        }
        if(temp == null && carry != 0){
            curr.next = new ListNode(carry);
        }
        dummy = dummy.next;
        // reverse again
        head = reverseLL(dummy);
        return head;
    }

}