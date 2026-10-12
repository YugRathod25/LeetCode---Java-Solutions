class Solution {
    public boolean comp(String haystack, String needle, int idx){
        int n = haystack.length();
        int m = needle.length();

        for(int i = 0; i < m; i++){

            if(idx >= n) return false;
            if(haystack.charAt(idx) != needle.charAt(i)){
                return false;
            }
            idx++;
        }
        return true;
    } 


    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        
        for(int i = 0; i < n; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(comp(haystack, needle, i)){
                    return i;
                }
            }
        }
        return -1;
    }
}