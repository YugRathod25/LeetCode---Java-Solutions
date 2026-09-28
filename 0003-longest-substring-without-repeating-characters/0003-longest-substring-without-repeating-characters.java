class Solution {
    public void addToMap(Map<Character, Integer> mp, char c){
        mp.put(c, mp.getOrDefault(c, 0) + 1);
    }

    public void deleteFromMap(Map<Character, Integer> mp, char c){
        mp.put(c, mp.get(c) - 1);
    }

    public boolean isValid(Map<Character, Integer> mp){
        for(char c: mp.keySet()){
            if(mp.get(c) > 1){
                return false;
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0; 
        int n = s.length();
        int fp = 0;
        int sp = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while(sp < n){
            addToMap(mp, s.charAt(sp));
            while(fp < sp && !isValid(mp)){
                deleteFromMap(mp, s.charAt(fp));
                fp++;
            }
            int len = sp - fp + 1;
            ans = Math.max(ans, len);
            sp++;
        }
        return ans;
    }
}