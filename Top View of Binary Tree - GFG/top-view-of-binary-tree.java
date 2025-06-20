//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> list = new ArrayList<>();
        int arr[] = new int[2] ;
        maxwidth(arr , root , 0);
        for(int i = 0 ; i < (arr[1]-arr[0]+1) ; i++){
            list.add(-1);
        }
        int min_vertical = 0 - arr[0] ;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(min_vertical , root));
        while(q.size() > 0){
            Pair rem = q.remove();
            if(list.get(rem.width) == -1)list.set(rem.width , rem.node.data) ;
            if(rem.node.left != null){
                q.add(new Pair(rem.width-1 , rem.node.left));
            }
            if(rem.node.right != null){
                q.add(new Pair(rem.width+1 , rem.node.right));
            }
        }
       return list ; 
    }
    private static class Pair{
        int width ;
        Node node ;  
        Pair(int width , Node node){
            this.width = width ;
            this.node = node ;
        }
    }
    public static void maxwidth(int arr[] , Node root , int level){
        if(root == null)return ;
        
        arr[0] = Math.min(level , arr[0]);
        arr[1] = Math.max(level , arr[1]);
        maxwidth(arr , root.left , level-1);
        maxwidth(arr , root.right , level+1);
    }
}