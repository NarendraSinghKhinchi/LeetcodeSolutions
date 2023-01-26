//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        char []arr = new char[str.length()] ;
        StringBuilder up = new StringBuilder();
        StringBuilder lo = new StringBuilder() ;
        for(int i = 0 ; i < str.length() ;i++){
            char ch =str.charAt(i) ;
            if(ch >= 'a' && ch <= 'z'){
                lo.append(ch);
                arr[i] = 1 ;
            }else{
                up.append(ch);
                arr[i] = 2 ;
            }
        }
        char arr1[] = up.toString().toCharArray();
        char arr2[] = lo.toString().toCharArray();
        StringBuilder ans = new StringBuilder();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0 ; 
        int j = 0 ;
        int k = 0 ;
        while(k < arr.length){
            if(arr[k] == 1){
                ans.append(arr2[i++]) ;
            }else{
                ans.append(arr1[j++]);
            }
            k++ ;
        }
        return ans.toString(); 
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends