//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        int arr[] = new int[26];
        for(int i = 0 ; i < S.length() ; i++){
            char ch = S.charAt(i);
            arr[ch-'a']++ ;
        }
        for(int i = 0 ; i < S.length() ; i++){
            char ch = S.charAt(i);
            if(arr[ch-'a'] == 1)return ch ;
        }
        return '$' ;
    }
}

