class Solution {
    public String simplifyPath(String path) {
        HashSet<String> set = new HashSet<>();
        set.add("");
        set.add("..");
        set.add(".");
        Deque<String> st = new ArrayDeque<>();
        for(String dir : path.split("/")){
            if(!st.isEmpty() && dir.equals(".."))st.pop();
            else if(set.contains(dir) == false)st.push(dir);
        }
        // StringBuilder sb = new StringBuilder();
        if(st.isEmpty())return "/";
        String res = "";
        for(String pa : st){
            // System.out.println(pa);
            res =   "/" + pa + res ;
        }
        return res ;
    }
}