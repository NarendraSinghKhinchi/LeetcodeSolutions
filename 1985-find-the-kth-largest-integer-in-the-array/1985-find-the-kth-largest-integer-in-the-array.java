class Solution {
    public String kthLargestNumber(String[] nums, int k) {
       
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String a , String b){
                if(a.length() > b.length())return -1;
                if(a.length() < b.length())return 1;
                if(a.length() == b.length()){
                    int i = 0 ;
                    while(i < a.length()){
                        if((a.charAt(i)-'0') > (b.charAt(i)-'0'))return -1;
                        if((a.charAt(i)-'0') < (b.charAt(i)-'0'))return 1;
                        i++ ;
                    }
                }
                return 0 ;
            }
        });
        
        for(int i =0 ; i < nums.length ; i++)pq.add(nums[i]);
          // while(!pq.isEmpty())System.out.println(pq.remove());
        while(k-- > 1)pq.remove();
        
        return pq.remove();
        // return "" ;
    }
}