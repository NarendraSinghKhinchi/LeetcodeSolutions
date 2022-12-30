/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.str = new StringBuilder() ;
        serializer(root);
        // System.out.println(str) ;
        return str.toString() ;
    }
    StringBuilder str = new StringBuilder() ;
    public void serializer(TreeNode root){
        if(root == null){
            str.append("n ") ;
            return ;
        }
        str.append( root.val+" ");
        serializer(root.left) ;
        serializer(root.right);
        
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(" ") ;
        if(arr[0].equals("n"))return null ;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0])) ;
        Pair p = new Pair(root , 0) ;
        Stack<Pair> st = new Stack<>() ;
        st.push(p) ;
        for(int i = 1 ; i < arr.length ; i++){
            String ch = arr[i] ;
            Pair rem = st.pop() ;
            TreeNode node ;
            if(ch.equals("n")){
                node = null ;
            }else{
                node = new TreeNode( Integer.parseInt(ch)) ;
            }
            if(rem.state == 0){
                rem.node.left = node ;
                rem.state = 1 ;
                st.push(rem) ;
            }else if(rem.state == 1){
                rem.node.right = node ;
            }
            if(node != null)st.push(new Pair(node , 0)) ;
        }
        return root  ;
    }
    private class Pair{
        TreeNode node ;
        int state ;
        Pair(TreeNode data , int state){
            this.node = data ;
            this.state = state ;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));