class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int ascii = 'z' - c + 1;
            sum = sum + ascii * (i+1);
        }
        return sum;
    }
}