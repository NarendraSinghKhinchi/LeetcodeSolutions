//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        int longest = 0 ;
        int dp[] = new int[size];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < a.length ; i++){
            int idx = helper(a[i] , list);
            dp[i] = idx+1 ;
            longest = Math.max(dp[i] , longest);
        }
        
        return longest ;
    }
    static int helper(int ele , ArrayList<Integer> list ){
        int low = 0 ;
        int hi = list.size()-1 ; 
        int pos = list.size();
        
        while(low <= hi){
            int mid = (low+hi)/2 ;
            if(list.get(mid) >= ele ){
                pos = mid ;
                hi = mid-1 ;
            }else{
                low = mid+1 ;
            }
        }
        
        if(pos == list.size()){
            list.add(ele);
        }else{
            list.set(pos , ele);
        }
        return pos ;
    }
} 