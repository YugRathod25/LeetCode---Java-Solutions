class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];

        for(int num : nums){
            count[num]++;
        }

        int[] ans = new int[2];
        for(int v = 1; v <= n; v++){
            if(count[v] == 2){
                ans[0] = v;      // duplicate
            }
            else if(count[v] == 0){
                ans[1] = v;      // missing
            }
        }
        return ans;
    }
}