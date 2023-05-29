//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        //code here
        ArrayList<String> list = new ArrayList<>();
        for(String str : Dictionary){
            String chars = "";
            for(int i = 0 ; i < str.length() ; i++){
                char ch = str.charAt(i);
                if(ch >= 'A' && ch <= 'Z'){
                    chars += ch ;
                }
            }
            if(compare(chars , Pattern))list.add(str);
        }
        if(list.size()== 0)list.add("-1");
        Collections.sort(list);
        return list ;
    }
    boolean compare(String chars , String Pattern){
        int i = 0 ; 
        int j = 0 ;
        while(i < chars.length() && j < Pattern.length()){
            if(chars.charAt(i) != Pattern.charAt(j))return false ;
            i++ ;
            j++ ;
        }
        if(j != Pattern.length())return false ;
        return true ;
    }
}  