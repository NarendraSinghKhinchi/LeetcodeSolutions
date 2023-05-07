//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        // code here
        int prev = 0 ;
        String ans = str.charAt(prev)+"";
        ans += ans ;
        if(str.length() > 1 && str.charAt(0) == str.charAt(1))return ans ;
        
        for(int i = 1 ; i < str.length() ; i++){
            if(str.charAt(i) <= str.charAt(prev))prev = i ;
            else break ;
        }
        ans = str.substring(0 , prev+1);
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        sb.reverse();
        
        return ans + sb.toString() ;
    }
}
