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
    public int[] nextLargerNodes(ListNode head) {
        // first lets convert this list in to array 
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        // in this stack we will store index of array

        for(int i = 0; i < n; i++){
            // so for each index well will get greater index
            while(!st.isEmpty() && list.get(i) > list.get(st.peek())){
                int prev = st.pop();
                ans[prev] = list.get(i);

            }
            st.push(i);
        }
        return ans;
    }
}