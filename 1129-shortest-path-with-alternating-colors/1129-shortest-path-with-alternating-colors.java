class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        ArrayList<Integer> redGraph[] = new ArrayList[n];
        ArrayList<Integer> blueGraph[] = new ArrayList[n];
        
        for(int i = 0 ; i < n ; i++){
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }
        
        for(int edge[] : redEdges){
            redGraph[edge[0]].add(edge[1]);
        }
        for(int edge[] : blueEdges){
            blueGraph[edge[0]].add(edge[1]);
        }
        
        int ans[] = new int[n];
        Arrays.fill(ans , -1);
        
        Queue<Node> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][2];
        q.add(new Node(0 , 0 , 0 ));
        q.add(new Node(0 , 1 , 0));
        ans[0] = 0 ;
        visited[0][0] = visited[0][1] = true ;
        while(q.isEmpty() == false){
            Node rem = q.remove();
            if(ans[rem.node] == -1){
                ans[rem.node] = rem.lsf ;
            }else{
                ans[rem.node] = Math.min(rem.lsf , ans[rem.node]);
            }
            visited[rem.node][rem.color] = true; 
            // 0 means red and 1 means blue
            if(rem.color != 0){
                ArrayList<Integer> nbrs = blueGraph[rem.node];
                for(int nei : nbrs){
                    if(visited[nei][0])continue ;
                    q.add(new Node(nei , 0 , 1+rem.lsf));
                }
            }
            if(rem.color != 1){
                ArrayList<Integer> nbrs = redGraph[rem.node];
                for(int nei : nbrs){
                    if(visited[nei][1])continue ;
                    q.add(new Node(nei , 1 , 1+rem.lsf));
                }
            }
            // System.out.println(q);
        }
        return ans ;
    }
    class Node{
        int node ;
        int color ;
        int lsf ;
        Node(int n , int c , int l){
            this.node = n ;
            this.color = c ;
            this.lsf = l ;
        }
    }
}