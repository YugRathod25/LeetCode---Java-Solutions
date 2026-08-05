class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int n = nums.length;
        int i = 0;
        int j = n - 1;

        while (i <= j){
            int mid = i + (j-i)/2;
            if (nums[mid] == target){
                result[0] = mid;
                j = mid - 1;
            }
            else if (nums[mid] > target){
                j = mid -1;
            }
            else{
                i = mid + 1;
            }
        }
        
        i = 0;
        j = n - 1;

        while(i <= j){
            int mid = i + (j-i)/2;
            if (nums[mid] == target){
                result[1] = mid;
                i = mid + 1;
            }
            else if (nums[mid] > target){
                j = mid -1;
            }
            else{
                i = mid + 1;
            }
        }
        return result;   
    }
}