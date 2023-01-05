class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()] ;
        int count = 0 ;
        Queue<Integer> q = new ArrayDeque<>() ;
        q.add(0) ;
        while(q.size() > 0){
            int rem = q.remove() ;
            if(visited[rem] == true )continue;
            visited[rem] = true ;
            count++ ;
            List<Integer> children = rooms.get(rem) ;
            for(int x : children)q.add(x) ;
            // System.out.println(q);
        }
        // System.out.println(count);
        return count == rooms.size() ? true : false ;
    }
}