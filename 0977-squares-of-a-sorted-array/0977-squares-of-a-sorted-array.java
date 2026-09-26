class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = n - 1;
        int pos = n - 1;

        while(i <= j){
            int leftSq = nums[i] * nums[i];
            int rightSq = nums[j] * nums[j];

            if(leftSq > rightSq){
                ans[pos] = leftSq;
                i++;
            }
            else{
                ans[pos] = rightSq;
                j--;
            }
            pos--;
        }

        return ans;
    }
}