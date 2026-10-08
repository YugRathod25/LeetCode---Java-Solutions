class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int depth = 0;

        for(char ch: s.toCharArray()){

            if(ch == '('){
                if(depth != 0){
                    str.append('(');
                }
                depth++;
            }

            else{ // ch == ')'

                depth--;
                if(depth != 0){
                    str.append(')');
                }
            }
        }

        return str.toString();
    }
}