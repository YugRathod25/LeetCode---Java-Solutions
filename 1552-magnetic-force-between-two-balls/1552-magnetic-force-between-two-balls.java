class Solution {

    static boolean isValidAns(int[] arr, int m, int minDistance){
        // now placing first ball to the 0th index
        int ballCount = 1;
        int lastPosition = 0;

        for(int i = 0; i < arr.length; i++){
            // now ill only place current ball to current pos, if diffrence between curr ball and prev ball is
            // >= min distance
            if (arr[i] - arr[lastPosition] >= minDistance){
                // it is safe to place a ball
                // increase ball cnt 
                ballCount++;
                // also update last position
                lastPosition = i;
                if(ballCount == m){
                    return true;
                }
            }
        }
        return false;
    }


    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int s = 0;
        int e = position[n-1] - position[0];
        int ans = -1;
        while (s <= e){
            int mid = s + (e -s)/2;

            if(isValidAns(position, m, mid)){
                // we found a posible solution, store it as an answer
                // move to right for better answer
                ans = mid;
                s = mid + 1;
            }

            else{
                // couldnt find a possible soltion, try with smaller value of mid
                // move to left
                e = mid - 1;
            }
        }
        return ans;
    }
}