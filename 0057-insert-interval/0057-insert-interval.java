class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>() ;
        boolean bool = true ;
        for(int i = 0 ; i < intervals.length ; i++){
            int inter[] = intervals[i] ;
            if(inter[0] >= newInterval[0] && bool){
                in(list , newInterval) ;
                bool = false ;
            }
            in(list , inter);
        }
        if(bool)in(list , newInterval) ;
        int ans[][] = new int[list.size()][] ;
        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }
        return ans ;
    }
    private void in(ArrayList<int[]> list , int inter[]){
        
        if(list.size() == 0){
            list.add(inter);
            return ;
        }
        int prev[] = list.get(list.size() - 1) ;
        if(prev[1] >= inter[0] ){
            prev[0] = Math.min(prev[0] , inter[0]) ;
            prev[1] = Math.max(prev[1] , inter[1]) ; 
        }else{
            list.add(inter);
        }
    }
}