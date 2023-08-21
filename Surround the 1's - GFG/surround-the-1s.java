//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int count = 0 ;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 1 && surround(matrix , i  , j )){
                    count += 1 ;
                }
            }
        }
        return count ;
    }
    public boolean surround(int[][]matrix , int i  , int j){
        int n = matrix.length ;
        int m = matrix[0].length ;
        int s = 0 ;
        
        if(i-1 >= 0 && matrix[i-1][j] == 0)s+=1 ;
        if(j-1 >= 0 && matrix[i][j-1] == 0)s+=1 ;
        if(i+1 < n && matrix[i+1][j] == 0)s+= 1 ;
        if(j+1 < m && matrix[i][j+1] == 0) s+= 1 ;
        
        if(i-1 >= 0 && j-1 >= 0 && matrix[i-1][j-1] == 0)s+=1 ;
        if(i-1 >= 0 && j+1 < m && matrix[i-1][j+1] == 0)s+=1 ;
        if(i+1 < n && j+1 < m && matrix[i+1][j+1] == 0)s+=1 ;
        if(i+1 < n && j-1 >= 0 && matrix[i+1][j-1] == 0)s+=1 ;
        
        if(s > 0 && s%2 == 0)return true ;
        return false ;
    }
}