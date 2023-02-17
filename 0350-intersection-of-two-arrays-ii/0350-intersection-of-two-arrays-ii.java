class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>() ;
        for(int i = 0 ; i< nums2.length ; i++){
            
            if(found(nums2[i] , nums1)){
                list.add(nums2[i]) ;
            }
        }
        int arr[] = new int[list.size()] ;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = list.get(i) ;
        }
        
        return arr ;
    }
        
    public boolean found(int ele , int arr[]){
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == ele){
                arr[i] = -1 ;
                return true ;
            }
        }
        return false ;
    }
}