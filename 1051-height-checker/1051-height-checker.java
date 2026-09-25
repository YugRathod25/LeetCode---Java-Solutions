class Solution {
    public int heightChecker(int[] heights) {
        int ans = 0;
        int n = heights.length;
        int[] copy = Arrays.copyOf(heights, n);
        Arrays.sort(copy);        
        for(int i = 0; i < n; i++){
            if(copy[i] != heights[i]){
                ans++;
            }
        }
        return ans;
    }
}