class Solution {
    public boolean canReach(int[] arr, int start) {
        
        boolean visited[] = new boolean[arr.length];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()){
            int rem = q.remove();
            if(arr[rem] == 0)return true ;
            
            visited[rem] = true ;
            int back = rem - arr[rem] ;
            int forth = rem + arr[rem] ;
            if(back >= 0 && !visited[back])q.add(back);
            if(forth < arr.length && !visited[forth])q.add(forth);
        }
        
        return false ;
    }
}