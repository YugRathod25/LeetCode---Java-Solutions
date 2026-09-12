class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while(i >= 0 || j >= 0){
            int digitA;
            if(i >= 0){
                digitA = a.charAt(i) - '0';
            }
            else{
                digitA = 0;
            }

            int digitB;
            if(j >= 0){
                digitB = b.charAt(j) - '0';
            }
            else{
                digitB = 0;
            }

            int sum = digitA + digitB + carry;

            ans.append(sum % 2);
            carry = sum / 2;
            i--; 
            j--;
        }
        
        if(carry > 0){
            ans.append(carry);
        }
        
        ans.reverse();
        return ans.toString();
    }
}