class Solution {
    public boolean isPerfectSquare(int num) {
        // for(int i=1 ; i*i <= num ; i++){
        //     if(i*i == num)return true ;
        // }
        // if(num == 1)return true ;
        long low = 1 ; 
        long high = num ;
        while(low <= high){
            long m = (low + high)/2 ;
            if(m*m == num)return true ;
            if(m*m < num)low = m+1 ;
            else high = m-1 ;
        }
        return false ;
    }
}
// public boolean isPerfectSquare(int num) {
//         long left = 1, right = num;
//         while (left <= right) {
//             long mid = (left + right) / 2;
//             if (mid * mid == num) return true; // check if mid is perfect square
//             if (mid * mid < num) { // mid is small -> go right to increase mid
//                 left = mid + 1;
//             } else {
//                 right = mid - 1; // mid is large -> to left to decrease mid
//             }
//         }
//         return false;
//     }