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
    public ListNode getMidPoint(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public ListNode reverseLL(ListNode head){
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
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        if(head.next == null){
            return true;
        }

        // find mid point -> break LL
        ListNode list2 = getMidPoint(head);

        // List 1 and List 2 seperate
        ListNode temp = head;

        while(temp.next != list2){
            temp = temp.next;
        }

        temp.next = null;

        // reverse list 2 
        ListNode head2 = reverseLL(list2);

        // compare both link list step by step
        ListNode temp1 = head;
        ListNode temp2 = head2;

        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val){
                return false;
            }
            else{
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        // return T or F
        return true;
    }
}