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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        if(head == null || head.next == null || head.next.next == null){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        ListNode temp = head.next;
        ListNode prev = head;
        int pos = 2;
        int minDist = Integer.MAX_VALUE;
        int firstCritPos = -1;
        int lastCritPos = -1;

        while(temp.next != null){
            if((temp.val > prev.val && temp.val > temp.next.val) || (temp.val < prev.val && temp.val < temp.next.val)){
                if(firstCritPos == -1){
                    firstCritPos = pos;
                }
                else{
                    int gap = pos - lastCritPos;
                    if(gap < minDist){
                        minDist = gap;
                    }
                }
                lastCritPos = pos;
            }
            temp = temp.next;
            prev = prev.next;
            pos++;
        }
        if(firstCritPos == -1 || firstCritPos == lastCritPos){
            ans[0] = -1;
            ans[1] = -1;
        }
        else{
            ans[0] = minDist;
            ans[1] = lastCritPos - firstCritPos;
        }
        return ans;
    }
}