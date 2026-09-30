class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        int ans = 1;
        for(int i = n-1; i >= 0 && s.charAt(i) != ' '; i--){
            ans++;
        }
        return ans-1;
    }
}