//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        int start = -1 ;
        int end = -1 ;
        int sum = 0;
        int cs = -1 ;
        int ce = -1 ;
        int csum = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(a[i] < 0){
                if(start == -1){
                    start = cs ;
                    end = ce ;
                    sum = csum ;
                }else{
                    if(csum > sum){
                        start = cs ;
                        end = ce ;
                        sum = csum ;
                    }else if(csum == sum){
                        int oldlength = end - start + 1 ;
                        int currlength = ce - cs + 1 ;
                        if(currlength > oldlength){
                            start = cs ;
                            end = ce ;
                            sum = csum ;
                        }else if(currlength == oldlength){
                            if(cs < start){
                                start = cs ;
                                end = ce ;
                                sum = csum ;
                            }
                        }
                    }
                }
                cs = -1 ;
                ce = -1 ;
                csum = 0 ;
            }else{
                if(cs == -1){
                    cs = i ;
                    ce = i ;
                    csum = a[i] ;
                }else{
                    ce = i ;
                    csum += a[i] ;
                }
            }
        }
        if(start == -1){
            start = cs ;
            end = ce ;
            sum = csum ;
        }else{
            if(csum > sum){
                start = cs ;
                end = ce ;
                sum = csum ;
            }else if(csum == sum){
                int oldlength = end - start + 1 ;
                int currlength = ce - cs + 1 ;
                if(currlength > oldlength){
                    start = cs ;
                    end = ce ;
                    sum = csum ;
                }else if(currlength == oldlength){
                    if(cs < start){
                        start = cs ;
                        end = ce ;
                        sum = csum ;
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if(start != -1){
            for(int i = start ; i <= end ;i++){
                list.add(a[i]);
            }
            
        }
        if(list.size()==0)list.add(-1);
        return list ;
    }
}