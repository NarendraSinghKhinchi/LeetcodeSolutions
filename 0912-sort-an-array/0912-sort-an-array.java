class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums , 0  ,nums.length-1);
        return nums ;
    }
    void merge(int arr[], int l, int m, int r)
    {
        // Your code here
        int n1 = m - l + 1 ;
        int n2 = r - m  ;
        
        int la[] = new int[n1] ;
        int ra[] = new int[n2] ;
        
        for(int i = 0 ; i < n1 ; i++){
            la[i] = arr[l+i];
        }
        for(int j = 0 ; j<n2 ; j++){
            ra[j] = arr[m+1+j];
        }
        
        int i = 0 , j = 0 ;
        while(i < n1 && j < n2){
            if(la[i] <=  ra[j]){
                arr[l] = la[i] ;
                i++ ;
                l++ ;
            }else{
               arr[l] = ra[j];
               j++ ;
               l++ ;
            }
        }
        while(i < n1 ){
            arr[l] = la[i] ;
            i++ ;
            l++ ;
        }
         while(j < n2 ){
            arr[l] = ra[j];
            j++ ;
            l++ ;
        }
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l == r){
            return ;
        }
        int mid = ( l + r ) / 2 ;
        mergeSort(arr , l , mid);
        mergeSort(arr ,mid + 1 , r);
        merge(arr , l , mid , r);
    }
}