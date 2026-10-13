class Solution {
    public int divide(int dividend, int divisor) {
        // Part A: the only overflow case
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        // Part B: sign of the answer
        boolean negative = (dividend < 0) != (divisor < 0);

        // Part C: absolute values as long
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        // Step 3: subtract the biggest chunk (b * 2^k) that fits, repeat
        long result = 0;
        while(a >= b){
            long temp = b;
            long multiple = 1;
            while(a >= (temp << 1)){
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        return negative ? (int) -result : (int) result;
    }
}