class Solution {

    static boolean isValidAns(int[] arr, int h, int bananaPerHour){
        long totalHour = 0;
        for (int i = 0; i < arr.length; i++){
            totalHour += (arr[i] + bananaPerHour - 1) / bananaPerHour;
        }
        return totalHour <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        for(int i = 0; i < n; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        int s = 1;
        int ans = -1;
        int e = max;
        while ( s <= e){
            int mid = s + ( e - s)/2;
            if (isValidAns(piles, h, mid)){
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