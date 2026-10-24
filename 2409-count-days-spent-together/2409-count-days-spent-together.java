class Solution {
    private int toDayNumber(String date){
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayOfYear = day;
        for(int m = 0; m < month - 1; m++){
            dayOfYear += daysInMonth[m];
        }
        return dayOfYear;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aStart = toDayNumber(arriveAlice);
        int aEnd = toDayNumber(leaveAlice);
        int bStart = toDayNumber(arriveBob);
        int bEnd = toDayNumber(leaveBob);

        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);         

        return Math.max(0, end - start + 1);
    }
}