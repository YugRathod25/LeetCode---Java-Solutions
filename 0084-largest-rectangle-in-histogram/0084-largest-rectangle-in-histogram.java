class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length; 
        Stack<Integer> st = new Stack<>();

        // first find nearest smallest rigth height 
        int[] nsr = new int[n];
        for(int i = 0; i <n; i++){
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int index = st.pop();
                nsr[index] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            nsr[st.pop()] = n;
        }

        st.clear(); // now will use this stack for nsl

        // first find nearest smallest left height
        int[] nsl = new int[n];
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsl[i] = -1;
            } 
            else {
                nsl[i] = st.peek();
            }

            st.push(i);
        }
        // now will find final answer

        for (int i = 0; i < n; i++) {

            int width = nsr[i] - nsl[i] - 1;
            int area = heights[i] * width;

            ans = Math.max(ans, area);
        }

        return ans;
    }
}