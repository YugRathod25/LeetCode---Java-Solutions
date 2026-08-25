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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode write = head;
        while(temp != null){
            int sum = 0;
            // calc value of sum till we encounter another 0
            while(temp.val != 0){
                sum += temp.val;
                temp = temp.next;
            }
            // overwrite the value of write Node with the value of sum
            write.val = sum;
            // delete other non needed node in between
            write.next = temp.next;
            // move read and write one step ahead 
            temp = temp.next;
            write = write.next;
        }
        return head;
    }
}