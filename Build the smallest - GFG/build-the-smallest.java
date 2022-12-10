//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int k) {
        // code here
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i) ;
            while(st.size() > 0 && k > 0 && ch < st.peek() ){
                st.pop() ;
                k-- ;
            }
            if(st.size() == 0 && ch == '0')continue ;
            st.push(ch);
        }
        while(k > 0 && st.size() > 0){
            st.pop();
            k-- ;
        }
        if(st.size() == 0)return "0" ;
        StringBuilder sb = new StringBuilder();
        for(char ch : st)sb.append(ch);
        

        return sb.toString();
    }
}