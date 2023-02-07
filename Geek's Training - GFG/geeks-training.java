//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int N){
        //code here
        int run = 0 ;
        int fight = 0 ;
        int practice = 0 ;
        for(int point[] : points){
            int r = point[0] + Math.max(fight , practice);
            int f = point[1] + Math.max(run , practice);
            int p = point[2] + Math.max(run , fight);
            run = r ;
            fight = f ;
            practice = p ;
        }
        return Math.max(run , Math.max(fight , practice));
    }
}