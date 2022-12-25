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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long  MissingNo(int[][] matrix)
    {
        // code here
        int row = -1 ;
        int col = -1 ;
        int rows = matrix.length ;
        int cols = matrix[0].length ;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(matrix[i][j] == 0){
                    row = i ;
                    col = j ;
                    break ;
                }
            }
            if(row != -1)break ;
        }
        
        long myrowsum = 0 ;
        for(int j = 0 ; j < cols ; j++)myrowsum += matrix[row][j] ;
        long rowsum = -1 ;
        // System.out.println(row + " "+ col + " " + myrowsum) ;
        for(int i = 0 ; i < rows ; i++){
            if(i == row)continue  ;
            long currsum = 0 ;
            for(int j = 0 ; j < cols ; j++){
                currsum += matrix[i][j] ;
            }
            rowsum = currsum ;
            break ;
        }
        // System.out.println(rowsum) ;
        long diff =  Math.abs(rowsum - myrowsum) ;
        // System.out.println("diff is " + diff) ;
        // matrix[row][col] = diff ;
        // checking rows
        for(int i = 0 ; i < rows ; i++){
            long currsum = 0 ;
            for(int j = 0 ; j< cols ; j++){
                if(i == row && j == col ){
                    currsum += diff ;
                }else{
                    currsum += matrix[i][j] ;
                }
            }
            if(currsum != rowsum)return -1 ;
        }
        long diagonalsum = 0 ;
        long reversediag = 0  ;
        for(int j = 0 ; j < cols ; j++){
            long currsum = 0 ;
            for(int i = 0 ; i < rows ; i++){
                long value = matrix[i][j] ;
                if(i == row && j == col){
                    value = diff ;
                }
                currsum += value ;
                if(i == j)diagonalsum += value ;
                if(i == (rows - j - 1)) reversediag += value ;
            }
            if(currsum != rowsum)return -1 ;
        }
        // System.out.println(diagonalsum) ;
        if(diagonalsum != reversediag || diagonalsum != rowsum || diff == 0)return -1 ;
        return diff ;
    }
}






