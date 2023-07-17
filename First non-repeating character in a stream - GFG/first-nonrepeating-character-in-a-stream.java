//{ Driver Code Starts
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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        int arr[] = new int[27];
        StringBuilder sb = new StringBuilder();
        int j = 0;
        
        for(int i= 0 ; i < A.length() ; i++){
            
            char ch = A.charAt(i);
            arr[ch-'a'] += 1 ;
            while(j < A.length() && arr[A.charAt(j)-'a'] > 1)j++ ;
            
            if(j <=  i){
                sb.append(A.charAt(j));
            }else sb.append("#");
        }
        return sb.toString();
    }
    
}