class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        
        int arr[] = new int[n] ;
        for(String log : logs){
            Log cont = new Log(log) ;
            if(cont.isStart == true){
                stack.push(cont);
            }else{
                Log pop = stack.pop() ;
                arr[pop.id] += (cont.time - pop.time + 1) ;
                if(!stack.isEmpty()){
                    arr[stack.peek().id] -= (cont.time - pop.time + 1) ;
                }
            }
        }
        return arr ;
    }
    class Log{
        int id, time ;
        boolean isStart = false ;
        Log(String log){
            String str[] = log.split(":") ;
            this.id = Integer.parseInt(str[0]) ;
            this.time = Integer.parseInt(str[2]) ;
            if(str[1].equals("start")){
                this.isStart = true ;
            }
        }
    }
}