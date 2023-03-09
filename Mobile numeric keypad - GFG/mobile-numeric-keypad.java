//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getCount(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public long getCount(int N)
	{
		// Your code goes here
		int key[][] = new int[][]{{1 , 2 , 3} , {4 , 5 , 6} , {7 , 8 , 9} , {-1 , 0 , -1}} ;
		long count = 0 ;
		this.dp  = new long[10][N+1];
	    for(long d[] : dp)Arrays.fill(d,-1);
		for(int i = 0 ; i < key.length ; i++){
		    for(int j = 0 ; j < key[0].length ; j++){
		        if(key[i][j] != -1){
		            count += dfs(i , j , key , 1 ,N );
		            
		        }
		    }
		}
		return count ;
	}
	long dp[][] ;
	public long dfs(int i , int j , int key[][] , int len , int N ){
	    if(i < 0 || j < 0 || i == key.length || j == key[0].length || key[i][j] == -1 || len > N)return 0 ;  
	    if(len == N)return 1 ;
	    if(dp[key[i][j]][len] != -1)return dp[key[i][j]][len] ;
	    long curr = dfs(i+1 , j , key , len+1 , N);
	    curr += dfs(i , j+1 , key , len+1 , N);
	    curr += dfs(i-1 , j , key , len+1 , N);
	    curr += dfs(i , j-1 , key , len+1 , N);
	    curr += dfs(i , j , key , len+1 , N);
	   // key[i][j] = -1 ;
	    dp[key[i][j]][len] = curr  ;
	    return curr ;
	}
	
}



