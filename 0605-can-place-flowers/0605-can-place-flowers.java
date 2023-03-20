class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)return true ;
        int c = 0 ;
        for(int i = 0 ; i < flowerbed.length ; i++){
            if(flowerbed[i] == 1) continue ;
            if(i > 0 && flowerbed[i-1] == 1)continue ;
            if(i < flowerbed.length - 1 && flowerbed[i+1] == 1)continue ;
            if(flowerbed[i] == 0){
                flowerbed[i] = 1 ;
                c++ ;
                // System.out.println(i) ;
            }
        }
        return c >= n ;
    }
}