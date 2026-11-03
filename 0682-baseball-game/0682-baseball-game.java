class Solution {
    public int calPoints(String[] operations) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(String op: operations){
            if(op.equals("+")){
                int top = st.pop();
                int second = st.peek();
                st.push(top);
                st.push(top + second);
            }
            else if(op.equals("D")){
                st.push(2 * st.peek());
            }
            else if(op.equals("C")){
                st.pop();
            }
            else{
                int score = Integer.parseInt(op);
                st.push(score);
            }
        }

        for(int score : st){
            ans += score;
        }

        return ans;
    }
}