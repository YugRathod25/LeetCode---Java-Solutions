class Solution {

    static boolean isValidAns(int arr[], int k, int mid){
        int kCount = 1;
        int subSum = 0;

        for (int i = 0; i < arr.length; i++){
            if (subSum + arr[i] <= mid){
                subSum += arr[i]; 
            }
            else{
                kCount++;
                if (kCount > k || arr[i] > mid){
                    return false;
                }
                else{
                    subSum = 0;
                    subSum = subSum + arr[i];
                }
            }
        }
        return true;
    }


    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            s = Math.max(s, nums[i]);
        }
        
        if (nums.length < k){
            return -1;
        }

        int e = sum;
        
        int ans = -1;

        while (s <= e){
            int mid = s + (e - s)/2;

            if (isValidAns(nums, k, mid)){
                ans = mid;
                e = mid -1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }
}