class Solution {

    static boolean isValidAns(int[] arr, int d, int maxCapa){
        int dayCount = 1;
        int maxWeight = 0;
        for(int i = 0; i < arr.length; i++){
            if(maxWeight + arr[i] <= maxCapa){
                maxWeight += arr[i];
            }
            else{
                dayCount++;
                if (dayCount > d || arr[i] > maxCapa){
                    return false;
                }
                else{
                    maxWeight = 0;
                    maxWeight = maxWeight + arr[i];
                }
            }
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int s = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += weights[i];
        }
        if (weights.length < days){
            return -1;
        }
        int e = sum;
        int ans = -1;
        while (s <= e){
            int mid = s + (e-s)/2;
            if(isValidAns(weights, days, mid)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }

        }
        return ans;
    }
}