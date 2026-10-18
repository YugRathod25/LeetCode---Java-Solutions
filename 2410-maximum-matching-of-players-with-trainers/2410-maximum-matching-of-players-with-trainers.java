class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int p = 0;
        int t = 0;
        while(p < players.length && t < trainers.length){
            if(players[p] <= trainers[t]){
                p++;
            }
            t++;
        }
        return p;
    }
}