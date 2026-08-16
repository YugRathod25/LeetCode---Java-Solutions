class Solution {
    public String reverseWords(String s) {
        // first make string builder as it is mutable
        StringBuilder ans = new StringBuilder();
        // first pointer at the last letter of last word of string
        int i = s.length() - 1;

        while(i >= 0 ){
            // remove all the trailing spaces
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            // cheack the value of i again
            if(i < 0){
                break;
            }
            int j = i;
            // this j pointer will travers whole word and will find the starting index of word
            while(j>= 0 && s.charAt(j) != ' '){
                j--;
            }
            // when j reaches space then stop and append this word in ans string
            ans.append(s.substring(j+1, i+1));
            // also remove unwanted spaces after one word
            while(j >= 0 && s.charAt(j) == ' '){
                j--;
            }
            //check validity and now we also have to add space after word is appended
            if(j >= 0){
                ans.append(' ');
            }
            // now place i at different word 
            i = j;
        }
        return ans.toString();
    }
}