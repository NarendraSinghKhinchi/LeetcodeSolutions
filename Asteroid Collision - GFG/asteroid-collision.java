//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int asteroid : asteroids){
            if(asteroid > 0){
                st.push(asteroid) ;
            }else{
                if((st.size() > 0 && st.peek() < 0) || st.size() == 0 ){
                    st.push(asteroid);
                }else{
                    int curr = asteroid ;
                    boolean eligible = false ;
                    while(st.size() > 0 && curr < 0){
                        int top = st.pop() ;
                        if(top < 0){
                            st.push(top) ;
                            eligible = true ;
                            break ;
                        }
                        if(Math.abs(top) == Math.abs(curr)){
                            eligible = false ;
                            break ;
                        }
                        if(Math.abs(top) > Math.abs(curr)){
                            st.push(top) ;
                            eligible = false ;
                            break ;
                        }
                        if(Math.abs(top) < Math.abs(curr)){
                            eligible = true ;
                        }
                    }
                    if(eligible)st.push(curr);
                }
                
            }
        }
        int arr[] = new int[st.size()] ;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            arr[i] = st.pop();
        }
        return arr ;
    }
}
