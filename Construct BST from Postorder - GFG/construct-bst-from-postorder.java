//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    public static Node constructTree(int post[],int n)
    {
        //Add your code here.
        return builder(post , 0 , n-1) ;
    }
    public static Node builder(int post[] , int low , int hi){
        if(low > hi)return null ;
        if(low == hi){
            return new Node(post[hi]) ;
        }
        Node node = new Node(post[hi]) ;
        int idx = hi-1 ;
        while(idx >= 0 && post[idx] > post[hi] )idx-- ;
        
        node.left = builder(post ,low , idx ) ;
        node.right = builder(post , idx+1 , hi-1 );
        return node ;
    }
}








