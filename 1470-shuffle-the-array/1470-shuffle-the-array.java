class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int i = 0;     
        int x = 0;     
        int y = n;     

        while(x < n){
            ans[i] = nums[x];
            i++;
            x++;
            ans[i] = nums[y];
            i++;
            y++;
        }
        return ans;
    }
}