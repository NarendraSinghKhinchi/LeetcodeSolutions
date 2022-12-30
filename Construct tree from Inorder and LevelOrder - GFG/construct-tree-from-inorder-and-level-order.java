//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}

// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
        this.hm = new HashMap<>();
        for(int i = 0 ; i < inord.length ; i++){
            hm.put(inord[i] , i) ;
        }
        // System.out.println(hm);
        Node root = builder(inord , level , 0 , inord.length - 1) ;
        // System.out.println();
        return root  ;
    }
    public Node builder(int []inorder, int[]levelorder , int ins , int ine){
        if(ins > ine)return null ;
        if(ins == ine){
            return new Node(inorder[ins]) ;
        }
        // if(levelorder == null)return null ;
        Node node = new Node(levelorder[0]) ;
        int idx = hm.get(levelorder[0]) ;
        int []left = new int[idx-ins] ;
        int []right = new int[ine-idx] ;
        fillsubtrees(idx ,ins , ine,inorder , levelorder , left , right) ;
        // for(int x : left)System.out.print(x + " ") ;
        // System.out.println();
        // for(int y : right)System.out.print(y + " ");
        node.left = builder(inorder , left , ins , idx - 1) ;
        node.right = builder(inorder , right , idx + 1 , ine);
        return node ;
    }
    HashMap<Integer,Integer> hm = new HashMap<>() ;
    void fillsubtrees(int idx, int ins, int ine,int[]inorder, int levelorder[], int left[], int right[]){
        // System.out.println(idx);
        int j = 0 ;
        int k = 0 ;
        for(int i = 0 ; i < levelorder.length ; i++){
            int databaseIdx = hm.get(levelorder[i]) ;
            if(inorder[idx] == levelorder[i])continue ;
            if(databaseIdx >= ins && databaseIdx <= ine){
                if(databaseIdx < idx){
                    left[j++] = levelorder[i] ;
                }
                if(databaseIdx > idx){
                    right[k++] = levelorder[i] ;
                }
            }
        }
        
    }
    
}


