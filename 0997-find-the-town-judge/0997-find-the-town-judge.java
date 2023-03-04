class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 1 ; i <= n ; i++){
            hm.put(i , new ArrayList<>());
        }
        // in hashmap list we store the person who trust i or key 
        for(int i = 0 ; i < trust.length ; i++){
            int person = trust[i][0] ;
            int trusted = trust[i][1] ;
            if(hm.containsKey(trusted)){
                ArrayList<Integer> list = hm.get(trusted);
                list.add(person);
            }
            if(hm.containsKey(person)){
                hm.remove(person);
            }
        }
        if(hm.size() == 0)return -1 ;
        if(hm.size() > 1)System.out.println("hurray you have two potential leaders!");
        for(int key : hm.keySet()){
            ArrayList<Integer> list = hm.get(key);
            if(list.size() == n-1)return key ;
        }
        return -1 ;
    }
}