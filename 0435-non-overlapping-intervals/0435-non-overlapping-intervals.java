class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals , new Comparator<int[]>(){
            
            public int compare(int a[] , int b[]){
                if(a[0] != b[0])return Integer.compare(a[0] , b[0]) ;
                else return Integer.compare(a[1] , b[1]) ;
            }
            
        });
        // curent start must be strictly less than previous end to make overlapping
        
       
        
        int count = 0 ;
        int prevend = intervals[0][1] ;
        for(int i = 1 ; i < intervals.length ; i++){
        
            int curr[] = intervals[i];
            if(curr[0] >= prevend){
                prevend = curr[1];
            }else{
                count++ ;
                prevend = Math.min(prevend , curr[1]);
            }
        }    
        return count  ;
    }
}