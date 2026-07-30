class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n){
            if(nums1[i] <= nums2[j]){
                merge[k] = nums1[i];
                i++;
                k++;
            }
            else if (nums2[j] < nums1[i]){
                merge[k] = nums2[j];
                k++;
                j++;
            }
        }
        while (i < m){
            merge[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n){
            merge[k] = nums2[j];
            j++;
            k++;
        }
        int l = merge.length;
        int start = 0; 
        int end = l - 1;
        double ans = 0;

        if( l % 2 == 1){
            int mid = start + (end - start)/2;
            ans = Math.round(merge[mid] * 10) / 10.0;
        }
        else{
            int mid1 = start + (end - start)/2;
            int mid2 = mid1 + 1;
            double subAns = (merge[mid1] + merge[mid2]) / 2.0;
            ans = Math.round(subAns * 10) / 10.0;
        }

        return ans;
    }
    
}