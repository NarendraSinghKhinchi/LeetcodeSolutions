class Solution {
    public int compareVersion(String version1, String version2) {
        String arr1[] = version1.split("\\.");
        String arr2[] = version2.split("\\.");
        
        int i = 0 ; 
        int j = 0 ;
        while(i < arr1.length && j < arr2.length){
            int fir = Integer.parseInt("0" + arr1[i]) ;
            int sec = Integer.parseInt("0" + arr2[j]) ;
            if(fir > sec)return 1 ;
            if(sec > fir)return -1 ;
            i++ ;
            j++ ;
        }
        while(i < arr1.length){
            int fir = Integer.parseInt("0" + arr1[i]) ;
            if(fir > 0)return 1 ;
            i++ ;
        }
        while(j < arr2.length){
            int fir = Integer.parseInt("0" + arr2[j]) ;
            if(fir > 0)return -1 ;
            j++ ;
        }
        
        return 0 ;
    }
}