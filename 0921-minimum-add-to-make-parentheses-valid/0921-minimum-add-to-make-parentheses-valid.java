class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int add = 0;

        for(char ch: s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    add++;
                }
                else{
                    st.pop();
                }
            }
        }
        return add + st.size();
    }
}