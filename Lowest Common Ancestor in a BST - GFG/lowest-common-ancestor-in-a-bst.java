//{ Driver Code Starts
//Initial Template for Java


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

class GfG {
    
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
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            //Scanner sc = new Scanner(System.in);
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    BST g = new BST();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");
        	    int x , y;
			    x = Integer.parseInt(arr[0]);
			    y = Integer.parseInt(arr[1]);
			    System.out.println(g.LCA(root,x,y).data);
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function Template for Java



class BST
{   
    //Function to find the lowest common ancestor in a BST. 
	Node LCA(Node root, int n1, int n2)
	{
        // code here.    
        ArrayList<Node> p = path(root , n1);
        ArrayList<Node> q = path(root , n2);
        // for(Node node : p){
        //     System.out.print(node.data+" ");
        // }
        // System.out.println();
        // for(Node node : q){
        //     System.out.print(node.data+" ");
        // }
         int i = q.size() - 1; 
         int j = p.size() - 1 ;
         while( ( i >= 0 && j >= 0) && (q.get(i).data == p.get(j).data)){
             i-- ;
             j-- ;
         }
         //  System.out.println();
        // if(j != -1)return p.get(j+1);
        return q.get(i+1);
    }
    ArrayList<Node> path(Node root , int d){
        if(root == null){
            return new ArrayList<Node>();
        }
        if(root.data == d){
            ArrayList<Node> list = new ArrayList<>();
            list.add(root);
            return list ;
        }
        ArrayList<Node> list = new ArrayList<>();
        if(root.data > d){
           list = path(root.left , d);
            if(list.size() != 0){
                list.add(root);
                return list ;
            }
        }else{
            list = path(root.right , d);
            if(list.size() != 0){
                list.add(root);
            }
            
        }
        return list ;
    }
    
}
