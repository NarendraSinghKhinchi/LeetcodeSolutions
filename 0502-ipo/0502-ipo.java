class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Project []ps = new Project[profits.length] ;
        for(int i = 0 ; i < profits.length ;i++){
            ps[i] = new Project(capital[i] , profits[i]) ;
        }
        Arrays.sort(ps , (a,b) -> Integer.compare(a.cap , b.cap));
        int front = 0 ;
        PriorityQueue<Project> pq = new PriorityQueue<>();
        
        while(front < ps.length && ps[front].cap <= w ){
            pq.add(ps[front++]) ;
        }
        int ans = w ;
        while(pq.isEmpty() == false && k-- > 0){
            Project bestOp = pq.remove();
            if(w < bestOp.cap)break ;
            
            w = w + bestOp.prof ;
            ans += bestOp.prof ;
            while(front < ps.length && ps[front].cap <= w ){
                pq.add(ps[front++]) ;
            }
        }
            
        return ans ;
    }
    class Project implements Comparable<Project>{
        int cap , prof ;
        Project(int cap , int prof){
            this.cap = cap ;
            this.prof = prof ;
        }
        public int compareTo(Project o){
            return Integer.compare(o.prof , this.prof);
        }
    }
}
