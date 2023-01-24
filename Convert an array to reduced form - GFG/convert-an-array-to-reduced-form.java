//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        //Code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0 ; i <n ; i++){
            pq.add(new Pair(i , arr[i]));
        }
        int i =  0 ;
        while(pq.isEmpty() == false){
            Pair rem = pq.remove();
            arr[rem.idx] = i++ ;
        }
        
    }
    class Pair implements Comparable<Pair>{
        int idx , val ;
        Pair(int i , int v){
            this.idx = i ; 
            this.val = v ;
        }
        public int compareTo(Pair o){
            return Integer.compare(this.val,o.val  );
        }
    }
}