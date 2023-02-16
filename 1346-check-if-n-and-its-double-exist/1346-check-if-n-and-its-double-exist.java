class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length ; i++){
            int low = 0 ;
            int high = arr.length - 1 ;
            while(low <= high){
                int mid = (low+high)/2 ;
                int sqr = 2*arr[i] ;
                // System.out.println(sqr + "  "+low + " "+high + "  "+mid);
                if( i != mid &&  sqr == arr[mid])return true ;
                if( sqr > arr[mid])low = mid+1 ;
                else high = mid-1 ;
                // System.out.println(sqr + "  "+low + " "+high + "  "+arr[mid]);
                // System.out.println(sqr + "  "+low + " "+high + "  "+mid);
            }
        }
        return false ;
    }
}