class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , new Comparator<int[]>(){
            
            public int compare(int a[] , int b[]){
                if(a[0] != b[0])return Integer.compare(a[0] , b[0]);
                else return Integer.compare(a[1],b[1]);
            }
        });
        
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1 ; i < intervals.length ; i++){
            int []ar = intervals[i] ;
            int st = ar[0];
            int en = ar[1];
            
            int pre[] = list.get(list.size() - 1);
            int str = pre[0] ;
            int end = pre[1] ;
            
            if(st <= end ){
                pre[0] = Math.min(str ,st);
                pre[1] = Math.max(en , end);
            }else{
                list.add(ar);
            }
        }
        int[] arr[] = new int[list.size()][];
        for(int i = 0 ; i < list.size() ; i++){
            arr[i] = list.get(i);
        }
        return arr ;
    }
}