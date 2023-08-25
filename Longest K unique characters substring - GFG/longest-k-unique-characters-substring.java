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
        HashMap<Character,Integer> hm = new HashMap<>();
        int i = 0 ;
        int len = -1 ;
        for(int j = 0 ; j < s.length() ; j++){
            char ch= s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size() > k){
                char ch2 = s.charAt(i);
                hm.put(ch2,hm.get(ch2)-1);
                if(hm.get(ch2)==0)hm.remove(ch2);
                i++ ;
            }
            if(hm.size() == k)
                len = Math.max(len , j-i+1);
        }
        return len ;
    }
}