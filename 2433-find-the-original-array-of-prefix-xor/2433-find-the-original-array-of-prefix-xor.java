class Solution {
    public int[] findArray(int[] pref) {
        
        int p = pref[0];
        int arr[] = new int[pref.length];
        arr[0] = p ;
        
        for(int i = 1 ; i < pref.length ;i++){
            arr[i] = (pref[i]  ^ p ) ;
            p = pref[i] ;
        }
        return arr ;
    }
}