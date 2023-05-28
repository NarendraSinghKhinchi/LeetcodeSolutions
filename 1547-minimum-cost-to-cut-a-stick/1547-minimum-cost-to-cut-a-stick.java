class Solution {
    public int minCost(int n, int[] cuts) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int cut : cuts)list.add(cut);
        list.add(0);
        list.add(n);
        Collections.sort(list);
        this.dp =  new int[list.size()][list.size()];
        
        for(int d[] : dp)Arrays.fill(d , -1);
        
        int cost = cutter(1 , list.size()-2 , list );
        
        return cost ;
    }
    int dp[][] ; 
    public int cutter(int st , int en , ArrayList<Integer>list  ){
        if(st > en)return 0 ;
        if(dp[st][en] != -1)return dp[st][en];
        int min = Integer.MAX_VALUE ;
        for(int idx = st ; idx <= en ; idx++){
            int cost = cutter(st , idx-1 , list) + cutter(idx+1 , en , list) + (list.get(en+1)-list.get(st-1)) ;
            min = Math.min(cost , min);
        }
        dp[st][en] = min ;
        return min ;
    }
}