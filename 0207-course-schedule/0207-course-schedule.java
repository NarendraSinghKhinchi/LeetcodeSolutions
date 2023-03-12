class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++)list.add(new ArrayList<>());
        
        for(int co[] : prerequisites){
            list.get(co[0]).add(co[1]);
        }
        int colors[] = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            if(colors[i] == 0 && canI(i , list , colors) )return false ;
            
        }
        return true ;
        // 0 means not visited by dfs // 1 means visited // 2 means fully processed
    }
    public boolean canI(int v ,ArrayList<ArrayList<Integer>> list , int colors[] ){
        if(colors[v] == 1)return true ;
        if(colors[v] == 2)return false ;
        
        colors[v] = 1 ;
        for(int i : list.get(v)){
            if(canI(i , list , colors) )return true ; 
        }
        colors[v] = 2 ;
        return false ;
    }
}