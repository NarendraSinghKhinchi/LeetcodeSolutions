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
        if(root == null)return "" ;
        StringBuilder sb = new StringBuilder() ;
        sb.append(root.val + " ");
        Queue<TreeNode> q = new ArrayDeque<>() ;
        q.add(root) ;
        while(q.size() > 0){
            TreeNode rem = q.remove() ;
            if(rem.left == null){
                sb.append("n ") ;
            }else if(rem.left != null){
                q.add(rem.left) ;
                sb.append(rem.left.val + " ") ;
            }
            if(rem.right == null){
                sb.append("n ") ;
            }else if(rem.right != null){
                q.add(rem.right) ;
                sb.append(rem.right.val + " ") ;
            }
        }
        for(int i = sb.length()-1 ; i >= 0 ; i--){
            if(sb.charAt(i) == 'n' || sb.charAt(i) == ' '){
                sb.deleteCharAt(i) ;
            }else break ;
        }
        // System.out.println(sb) ;
        return sb.toString() ;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)return null ;
        String arr[] = data.split(" ") ;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0])) ;
        Queue<TreeNode> q = new ArrayDeque<>() ;
        q.add(root);
        int i = 1 ;
        while(q.size() > 0 && i < arr.length){
            String currVal = arr[i] ;
            // System.out.println(currVal) ;
            TreeNode rem = q.remove() ;
            if(!currVal.equals("n")){
                rem.left = new TreeNode(Integer.parseInt(currVal)) ;
                q.add(rem.left) ;
            }
            i++ ;
            if(i >= arr.length)break ;
            currVal = arr[i] ;
            if(!currVal.equals("n")){
                rem.right = new TreeNode(Integer.parseInt(currVal));
                q.add(rem.right);
            }
            i++ ;
        }
        return root ;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;