class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length ;
        int players[][] = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        Arrays.sort(players, new Comparator<int[]>(){
            @Override
            public int compare(int a[] , int b[]){
                if(a[0] != b[0])return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            }
        });
        Arrays.fill(scores , 0);
        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            scores[i] = players[i][1];
            int max = 0 ;
            for(int j = 0 ; j < i ; j++){
                if(players[i][1] >= players[j][1]){
                    max = Math.max(max , scores[j]);
                }
            }
            scores[i] += max ;
            ans = Math.max(ans , scores[i]);
        }
        return ans ;
    }
}