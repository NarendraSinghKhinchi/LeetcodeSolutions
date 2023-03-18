//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        if(k == 0)return 0 ;
        HashMap<Character , Integer> hm = new HashMap<>() ;
        int longest = -1 ;
        int j = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            hm.put(ch , hm.getOrDefault(ch ,0)+1);
            
            while(hm.size() > k && j < i ){
                char ch2 = s.charAt(j++);
                hm.put(ch2 , hm.get(ch2)-1);
                if(hm.get(ch2) == 0)hm.remove(ch2);
            }  
            if(hm.size() == k){
                longest = Math.max(longest , i-j+1);
            }
        }
        return longest ;
    }
}