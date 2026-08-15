class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            totalXor = totalXor ^ nums[i];
        }
        if(totalXor != 0){
            return n;
        }
        else{
            for(int i = 0; i < n; i++){
                if(nums[i] != 0){
                    return n-1;
                }
            }
            return 0;
        }
    }
}