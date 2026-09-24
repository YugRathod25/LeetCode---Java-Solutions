class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        int target = totalSum - x;
        if(target < 0){
            return -1;
        }
        if(target == 0){
            return nums.length;
        }

        int i = 0;
        int currentSum = 0;
        int maxLen = -1;

        for(int j = 0; j < nums.length; j++){
            currentSum += nums[j];

            while(currentSum > target && i <= j){
                currentSum -= nums[i];
                i++;
            }

            if(currentSum == target){
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        if(maxLen == -1){
            return -1;
        }
        return nums.length - maxLen;
    }
}