class Solution {
    public String decodeString(String s) {
        Stack<Integer> cntSt = new Stack<>();
        Stack<StringBuilder> stringSt = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();

        for(char ch: s.toCharArray()){
            // case 1 if it is a digit
            if(Character.isDigit(ch)){
                num = num*10 + (ch - '0');
            }

            // case 2 if it is a opening bracket
            else if(ch == '['){
                cntSt.push(num);
                stringSt.push(curr);
                // re initialize 
                num = 0;
                curr = new StringBuilder();
            }

            //case 3 it is a closing bracket
            else if(ch == ']'){
                int repeatCnt = cntSt.pop();
                StringBuilder prev = stringSt.pop();

                for(int i = 1; i <= repeatCnt; i++){
                    prev.append(curr);
                }

                curr = prev;
            }

            // case 4 when it is an char
            else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}