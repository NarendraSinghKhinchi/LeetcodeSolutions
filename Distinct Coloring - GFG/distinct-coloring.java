//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
        long lastr = 0 ;
        long lastg = 0 ;
        long lastb = 0 ;
        for(int i = 0 ; i < N ; i++){
            long currr = r[i] + Math.min(lastg , lastb);
            long currg = g[i] + Math.min(lastr , lastb);
            long currb = b[i] + Math.min(lastg , lastr);
            lastr = currr ;
            lastg = currg ;
            lastb = currb ;
        }
        return Math.min(lastr , Math.min(lastg , lastb));
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends