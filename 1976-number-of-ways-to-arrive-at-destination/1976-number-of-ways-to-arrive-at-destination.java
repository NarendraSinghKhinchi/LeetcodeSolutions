// class Solution {
//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<int[]>> list = new ArrayList<>();
//         for(int i =0 ; i < n ; i++)list.add(new ArrayList<>());
        
//         int mod = (int) (1e9+7) ;
        
//         for(int road[] : roads){
//             list.get(road[0]).add(new int[]{road[1] , road[2]});
//             list.get(road[1]).add(new int[]{road[0] , road[2]});
//         }
//         long ways[] = new long[n];
//         int dis[] = new int[n] ;
//         Arrays.fill(dis , Integer.MAX_VALUE);
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1] , b[1]));
//         // src , time
//         ways[0] = 1 ;
//         dis[0] = 0 ;
//         pq.add(new int[]{0 , 0});
        
//         while(!pq.isEmpty()){
//             int rem[] = pq.remove();
//             int sr = rem[0] ;
//             int t = rem[1] ;
            
//             for(int nbr [] : list.get(sr)){
//                 if(nbr[1] + t < dis[nbr[0]]){
//                     pq.add(new int[]{nbr[0] , nbr[1]+t});
//                     dis[nbr[0]] = nbr[1] + t ;
//                     ways[nbr[0]] = ways[sr] ;
//                 }else 
//                 if(nbr[1] + t == dis[nbr[0]]){
//                     ways[nbr[0]] = (ways[nbr[0]] + ways[sr])%mod ;
//                 }
//             }
//         }
        
//         return (int)(ways[n-1] %  mod) ;
//     }
// }
    class pair{
	int node;
	int value;

	public pair(int n, int v){
		this.node=n;
		this.value=v;
	}
}


class Solution {
	public int countPaths(int n, int[][] roads) {
	//Creating adj list
		ArrayList<ArrayList<pair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++)adj.add(new ArrayList<>());
		for(int i=0;i<roads.length;i++){
			adj.get(roads[i][0]).add(new pair(roads[i][1], roads[i][2]));
			 adj.get(roads[i][1]).add(new pair(roads[i][0], roads[i][2]));
			 
			// this will basically segregate all nodes in one place
		}

		Queue<pair> q = new PriorityQueue<>((x,y)->x.value-y.value);
		int[] values = new int[n];
		int[] distance = new int[n];
		Arrays.fill(values,Integer.MAX_VALUE);
		values[0]=0; // this will store all its min path distance
		distance[0]=1; // this will store all the no.of ways passing through the current node;
		int mod = 1000000000+7;

		q.offer(new pair(0,0));// pushin first node that is src node
		while(!q.isEmpty()){
			int node = q.peek().node; // storing the values of first node so that we can add its children
			int value = q.peek().value;
			q.poll();

			for(pair p:adj.get(node)){  // traversing through that node list to reach push it's children having less distances
			
				int newnode = p.node;
				int newvalue = p.value;

				if(value+newvalue < values[newnode]){ // will compare if this new path has less distance than the previous path distance
					values[newnode] = value+newvalue;
					distance[newnode]=distance[node];
					q.offer(new pair(newnode, values[newnode]));
				}

				else if(value+newvalue == values[newnode]){ // checking if same value exist, if yes then we need to wo got another route to reach our destination
					distance[newnode]=(distance[newnode]+ distance[node])%mod; 
				}
			}
		}

		return distance[n-1]%mod; // they've mentioned to return the no.of ways so we're returning that ways
	}
}
