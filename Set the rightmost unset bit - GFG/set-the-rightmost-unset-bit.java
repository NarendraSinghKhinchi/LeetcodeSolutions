//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans  = ob.setBit(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setBit(int N){
        // code here
        int ans = N ;
        int pos = 0 ;
        while(N != 0){
            if((N & 1 ) > 0){
                pos++ ;
            }else{
                return (ans | (1 << pos));
            }
            N = (N >> 1);
            
        }
        return ans ;
    }
}