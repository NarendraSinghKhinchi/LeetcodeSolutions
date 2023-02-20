class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        ArrayList<int []> list = new ArrayList<>() ;
        
        int i = 0 ; 
        int j = 0 ;
        while(i < firstList.length && j < secondList.length){
            int start = Math.max(firstList[i][0] , secondList[j][0]) ;
            int end = Math.min(firstList[i][1] , secondList[j][1]) ;
            if(end == firstList[i][1])i++ ;
            if(end == secondList[j][1])j++ ;
            if(start <= end){
                list.add(new int[]{start , end}) ;
            }
        }
        int arr[][] = new int[list.size()][2] ;
        for( i = 0 ; i < arr.length ; i++){
            arr[i] = list.get(i) ;
        }
        return arr ;
    }
}