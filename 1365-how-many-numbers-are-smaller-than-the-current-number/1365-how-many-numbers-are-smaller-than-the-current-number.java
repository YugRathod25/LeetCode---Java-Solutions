class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        for(int i = 0; i < nums.length; i++){
            cnt[nums[i]]++;
        }

        for(int v = 1; v <= 100; v++){
            cnt[v] += cnt[v - 1];
        }

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                ans[i] = 0;
            }
            else{
                ans[i] = cnt[nums[i] - 1];
            }
        }
        return ans;
    }
}