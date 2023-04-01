class Solution {
    public int search(int[] arr, int target) {
        int l = 0 ; 
        int h = arr.length - 1 ; 
        while(l <= h){
            int m = (l+h)/2 ;
            if(arr[m] == target)return m ;
            if(arr[m] < target)l = m+1 ;
            else h = m-1 ;
        }
        return -1 ;
    }
}