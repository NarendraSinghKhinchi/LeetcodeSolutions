class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int adj[][] = new int[26][26];
        for(int i = 0 ; i < s1.length() ; i++){
            int a = (s1.charAt(i) - 'a') ;
            int b = (s2.charAt(i) - 'a') ;
            adj[a][b] = 1 ;
            adj[b][a] = 1 ;
        }
        int map[] = new int[26] ;
        for(int i = 0 ; i < 26 ; i++)map[i] = i ;
        boolean visited[] = new boolean[26] ;
        for(int src = 0 ; src < 26 ; src++){
           if(visited[src] == false){
               ArrayList<Integer> list = new ArrayList<>();
               this.min = 27 ;
               dfs(src , adj , visited , list);
               for(int vertex : list){
                   map[vertex] = min ;
               }
           } 
        }
        String ans = "" ;
        for(char c : baseStr.toCharArray()){
            ans += (char)(map[c-'a']+'a');
        }
        return ans;
    }
    int min = 27 ;
    public void dfs(int src , int adj[][] , boolean visited[] , ArrayList<Integer> list){
        visited[src] = true ;
        list.add(src);
        min = Math.min(min , src);
        for(int i = 0 ; i < 26 ; i++){
            if(adj[src][i] == 1 && !visited[i]){
                dfs(i , adj , visited , list);
            }
        }
    }
}









