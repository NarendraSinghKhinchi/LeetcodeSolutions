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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                boolean up = up(grid , i , j , word);
                boolean down = down(grid , i , j , word);
                boolean left = left(grid , i , j , word);
                boolean right = right(grid , i , j , word);
                boolean topLeft = topLeft(grid , i , j , word);
                boolean topRight = topRight(grid , i , j , word);
                boolean bottomLeft = bottomLeft(grid , i , j , word);
                boolean bottomRight = bottomRight(grid , i , j , word);
                if(up || down || left || right || topLeft || topRight || bottomLeft || bottomRight){
                    list.add(new int[]{i , j});
                }
            }
        }
        int ans[][] = new int[list.size()][2];
        for(int i =0 ; i < ans.length ;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public boolean up(char[][]grid , int i , int j , String word){
        if(word.length() == 0)return true ;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)return false ;
        char ch = word.charAt(0);
        if(grid[i][j] != ch)return false ;
        if(word.length() == 1)return true ;
        return up(grid , i-1 , j  , word.substring(1));
    }
    public boolean down(char[][]grid , int i , int j , String word){
        if(word.length() == 0)return true ;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)return false ;
        char ch = word.charAt(0);
        if(grid[i][j] != ch)return false ;
        if(word.length() == 1)return true ;
        return down(grid , i+1 , j  , word.substring(1));
    }
    public boolean left(char[][]grid , int i , int j , String word){
        if(word.length() == 0)return true ;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)return false ;
        char ch = word.charAt(0);
        if(grid[i][j] != ch)return false ;
        if(word.length() == 1)return true ;
        return left(grid , i , j-1  , word.substring(1));
    }
    public boolean right(char[][]grid , int i , int j , String word){
        if(word.length() == 0)return true ;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)return false ;
        char ch = word.charAt(0);
        if(grid[i][j] != ch)return false ;
        if(word.length() == 1)return true ;
        return right(grid , i , j+1  , word.substring(1));
    }
    public boolean topLeft(char[][]grid , int i , int j , String word){
        if(word.length() == 0)return true ;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)return false ;
        char ch = word.charAt(0);
        if(grid[i][j] != ch)return false ;
        if(word.length() == 1)return true ;
        return topLeft(grid , i-1 , j-1  , word.substring(1));
    }
    public boolean topRight(char[][]grid , int i , int j , String word){
        if(word.length() == 0)return true ;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)return false ;
        char ch = word.charAt(0);
        if(grid[i][j] != ch)return false ;
        if(word.length() == 1)return true ;
        return topRight(grid , i-1 , j+1  , word.substring(1));
    }
    public boolean bottomRight(char[][]grid , int i , int j , String word){
        if(word.length() == 0)return true ;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)return false ;
        char ch = word.charAt(0);
        if(grid[i][j] != ch)return false ;
        if(word.length() == 1)return true ;
        return bottomRight(grid , i+1 , j+1  , word.substring(1));
    }
    public boolean bottomLeft(char[][]grid , int i , int j , String word){
        if(word.length() == 0)return true ;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)return false ;
        char ch = word.charAt(0);
        if(grid[i][j] != ch)return false ;
        if(word.length() == 1)return true ;
        return bottomLeft(grid , i+1 , j-1  , word.substring(1));
    }
}