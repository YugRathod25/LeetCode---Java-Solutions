/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode listA = headA;
        ListNode listB = headB;

        // this while will let us know which one will reach at null first
        while(listA != null && listB != null){
            listA = listA.next;
            listB = listB.next;
        }

        if(listA == null){
            // if A is reaching to null first so definetely B is bigger or equal to A
            int BExtraLen = 0;
            while(listB != null){
                listB = listB.next;
                BExtraLen++;
            }
            while(BExtraLen-- > 0){
                headB = headB.next;
            }
        }
        else{ // listB == null
            // if B is reaching to null first so definetely A is bigger or equal to B
            int AExtraLen = 0;
            while(listA != null){
                listA = listA.next;
                AExtraLen++;
            }
            while(AExtraLen-- > 0){
                headA = headA.next;
            }
        }

        // now we have both list of same length so now we can check the following condition to reach our answer
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}