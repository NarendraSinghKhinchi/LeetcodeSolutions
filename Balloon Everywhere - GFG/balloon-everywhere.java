//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        int arr[] = new int[26] ;
        // 0 = b , 1 = a , 2 = l , 3 = o , 4 = n
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            arr[ch-'a']++ ;
        }
        String str = "balloon" ;
        int ans = Integer.MAX_VALUE ;
        arr['l'-'a'] /= 2 ;
        arr['o' - 'a'] /= 2;
        for(int i = 0 ;i < str.length() ; i++){
            int idx = str.charAt(i)-'a' ;
            ans = Math.min(ans , arr[idx]);
        }
        return ans ;
    }
}