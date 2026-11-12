class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sec = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < tickets.length; i++){
            q.offer(i);
        }
        while(tickets[k] > 0){
            int index = q.poll();
            tickets[index]--;
            sec++;

            if(tickets[index] > 0){
                q.offer(index);
            }
        }
        return sec;
    }
}