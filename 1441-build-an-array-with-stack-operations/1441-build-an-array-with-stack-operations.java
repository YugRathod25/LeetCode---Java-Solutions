class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int cur = 1;                      // next number coming from the stream

        for(int t : target){
            while(cur < t){               // numbers we skip: push, then immediately pop
                ops.add("Push");
                ops.add("Pop");
                cur++;
            }
            ops.add("Push");              // cur == t, so this one stays in the stack
            cur++;
        }
        return ops;
    }
}