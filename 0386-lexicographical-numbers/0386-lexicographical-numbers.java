class Solution {
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++){
            recurs(list ,i , n);
        }
       return list ;
    }
    public void recurs(List<Integer> list ,int i, int n){
        if(i > n)return ;
        list.add(i);
        i = i * 10 ;
        for(int j = 0 ; j <= 9 ; j++){
            if(i + j > n)break ;
            recurs(list , i + j , n );
        }
    }
}