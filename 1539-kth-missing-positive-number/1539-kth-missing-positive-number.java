class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int idx = 0 ;
        int missing = 0 ;
        for(int i = 1 ; i <= 1000 ; i++){
            if(idx < arr.length && arr[idx] == i)idx++ ;
            else 
                missing += 1 ;
            
            if(missing == k)return i ;
            if(idx == arr.length){
                return (k-missing) + arr[idx-1] ;
            }
        }
        return -1;
        
    }
}