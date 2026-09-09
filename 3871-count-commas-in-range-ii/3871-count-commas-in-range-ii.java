class Solution {
    public long countCommas(long n) {
        int commaCnt = 1;
        long total = 0;
        if(n < 1000){
            return 0;
        }
        for(long i = 1000; i <= n; i *= 1000){
            long temp = i*1000 - 1;
            if(n <= temp){
                total += (n - i + 1) * commaCnt;
            }
            else{
                total += (temp - i + 1) * commaCnt;
            }
            
            commaCnt++;
        }
        return total;
    }
}