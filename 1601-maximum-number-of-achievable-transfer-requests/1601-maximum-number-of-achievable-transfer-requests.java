class Solution {
    public int maximumRequests(int n, int[][] requests) {
        this.ans = 0 ;
        
        backtrack(requests , 0 , 0 , new int[n]);
        return ans ;
    }
    int ans ;
    public void backtrack(int[][]requests, int idx , int count , int arr[]){
        if(idx == requests.length){
            for(int x : arr)if(x != 0)return ;
            ans = Math.max(ans , count);
            return ;
        }
        int x = requests[idx][0] ;
        int y = requests[idx][1] ;
        
        arr[x]-- ;
        arr[y]++ ;
        backtrack(requests , idx+1 , count+1 , arr);
        arr[x]++ ;
        arr[y]-- ;
        backtrack(requests , idx+1 , count , arr);
    }
}