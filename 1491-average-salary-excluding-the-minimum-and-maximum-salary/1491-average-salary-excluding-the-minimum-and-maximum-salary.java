class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;
        int sum = 0 ;
        for(int x : salary){
            sum += x ;
            max = Math.max(x , max);
            min = Math.min(x , min);
        }
        int n = salary.length ;
        double dd  = sum - (max+min);
        double ans = dd / (n-2);
        return ans ;
    }
}