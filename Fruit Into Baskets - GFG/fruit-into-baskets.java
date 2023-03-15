//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        int left = 0;
        int right = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        
        int len = 0;
        while(right < N){
            hm.put(fruits[right] , hm.getOrDefault(fruits[right] , 0)+1);
            while(hm.size() > 2 && left <= right){
                hm.put(fruits[left] , hm.get(fruits[left])-1);
                if(hm.get(fruits[left] )== 0){
                    hm.remove(fruits[left]);
                }
                left++ ;
            }
            len = Math.max(len , right-left+1);
            right++ ;
        }
        return len ;
    }
}