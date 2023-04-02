class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        
        int arr[] = new int[spells.length];
        
        for(int i = 0 ; i < spells.length ; i++){
            int bin = binary(spells[i] , potions , success);
            arr[i] = bin ;
        }
        return arr ;
    }
    public int binary(long spell , int potion[] , long success){
        int most = potion.length ;
        int lo = 0 ;
        int hi = potion.length - 1 ;
        while(lo <= hi){
            int mid = (lo + hi)/2 ;
            long com = (long)(potion[mid] * spell) ;
            if(com >= success){
                most = mid ;
                hi = mid-1 ;
            }else {
                lo = mid+1 ;
            }
        }
        
        return potion.length - most ;
    }
}