class Solution {
    public String frequencySort(String s) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String a , String b){
                return b.length() - a.length() ;
            }
        });
        StringBuilder arr[] = new StringBuilder[200];
        for(int i = 0 ;i < 200 ; i++){
            arr[i] = new StringBuilder();
        }
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            arr[ch-'0'].append(ch);
        }
        for(int i = 0 ; i < 200 ; i++){
            pq.add(arr[i].toString());
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            ans.append(pq.remove());
        }
        return ans.toString();
    }
}