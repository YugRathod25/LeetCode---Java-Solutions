class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        
        String parts[] = path.split("/");
        for(String part: parts){

            if(part.isEmpty() || part.equals(".")){
                continue;
            }

            if(part.equals("..") && st.isEmpty()){
                continue;
            }

            if(part.equals("..") && !st.isEmpty()){
                st.pop();
            }
            else{
                st.push(part);
            }
        }

        if(st.isEmpty()){
            return "/";
        }
        else{
            StringBuilder str = new StringBuilder();

            for(String dir : st){
                str.append("/");
                str.append(dir);
            }

            return str.toString();
        }
    }
}