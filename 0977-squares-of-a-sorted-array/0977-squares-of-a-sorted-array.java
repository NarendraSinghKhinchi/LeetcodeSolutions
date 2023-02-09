class Solution {
    public int[] sortedSquares(int[] nums) {
        int arr[] = new int[nums.length] ;
        int i = 0 ; 
        int j = nums.length-1 ;
        for(int k = nums.length-1 ; k >= 0 ; k--){
            int a = nums[i] * nums[i] ;
            int b = nums[j] * nums[j] ;
            if(a > b){
                arr[k] = a ;
                i++ ;
            }else {
                arr[k] = b ;
                j-- ;
            }
        }
        return arr ;
    }
}