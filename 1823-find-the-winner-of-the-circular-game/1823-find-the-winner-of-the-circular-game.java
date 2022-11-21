class Solution {
    public int findTheWinner(int n, int k) {
        return recurs(n , k - 1) + 1 ;
    }
    public int recurs(int n , int k ){
        if(n == 0)return 0 ;
        int t = recurs(n-1 , k) ;
        return (t + k + 1) % n ;
    }
}