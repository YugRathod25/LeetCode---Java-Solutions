class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int area = 0;
        int start = 0; 
        int end = n-1;
        while (start <= end){
            int tempArea = 0;
            if(height[start] <= height[end]){
                tempArea = height[start] * (end - start);
                start++;

            }
            else{
                tempArea = height[end] * (end - start);
                end--;
            }
            if(tempArea > area)
                area = tempArea;
        }
        return area;
    }
}