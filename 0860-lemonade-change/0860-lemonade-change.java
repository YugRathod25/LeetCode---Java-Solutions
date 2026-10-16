class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cnt10 = 0;
        int cnt5 = 0;
        for(int bill : bills){
            if(bill == 5){
                cnt5++;
            }
            else if(bill == 10){
                if(cnt5 == 0){
                    return false;
                }
                cnt5--;
                cnt10++;
            }
            else{
                if(cnt10 > 0 && cnt5 > 0){
                    cnt10--;
                    cnt5--;
                }
                else if(cnt5 >= 3){
                    cnt5 -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}