/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return null ;
        HashMap<Integer , Node> set = new HashMap<>();
        return clonee(set , node);
    }
    public Node clonee(HashMap<Integer , Node> set , Node node ){
        if(set.keySet().contains(node.val)){
            return set.get(node.val);
        }
        Node par = new Node(node.val);
        set.put(par.val , par);
        for(Node nbrs : node.neighbors){
            Node child = clonee(set , nbrs);
            par.neighbors.add(child);
        }
        return par ;
    }
}