class Solution {
    public int largestAltitude(int[] gain) {
        int sum =0;
        int ans = 0;
        int n = gain.length;
        for(int i = 0; i < n; i++){
            sum = sum + gain[i];
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;
    }
}