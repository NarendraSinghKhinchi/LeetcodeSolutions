class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        int visit = 0 ;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while(q.isEmpty() == false){
            int curr = q.remove();
            
            List<Integer> available = rooms.get(curr);
            visited[curr] = true ;
            for(int x : available){
                if(!visited[x]){
                    q.add(x);
                    
                }
            }
        }
        for(boolean bool : visited)if(!bool)return false ;
        return true ;
    }
}