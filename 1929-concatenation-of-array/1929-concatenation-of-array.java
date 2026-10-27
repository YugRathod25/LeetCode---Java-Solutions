class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] arr=new int[2*n];
        int i=0;
        int j=i+n;
        while(i<n){
            int num=nums[i];
            arr[i++]=num;
           
            arr[j++]=num;
        }
        return arr;
    }
}