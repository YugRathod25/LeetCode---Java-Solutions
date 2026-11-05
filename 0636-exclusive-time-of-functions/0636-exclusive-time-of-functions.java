class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;

        for(String log : logs){
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if(type.equals("start")){
                if(!st.isEmpty()){
                    ans[st.peek()] += time - prev;
                } 
                st.push(id);
                prev = time;
            }
            else{   // "end"
                int top = st.pop();
                ans[top] += time - prev + 1;
                prev = time + 1;  
            }
        }
        return ans;
    }
}