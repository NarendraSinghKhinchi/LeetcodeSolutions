class Solution {
    public boolean canJump(int[] nums) {
        boolean jump[] = new boolean[nums.length] ;
        
        jump[nums.length-1] = true ;
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            int curr = nums[i] ;
            for(int j = 1 ; j <= curr ; j++){
                // System.out.println(i +  " " + curr) ;
                if(j + i  < nums.length && jump[j+i]){
                    jump[i] = true ;
                    break ;
                } 
            }
            // System.out.println(jump[i]) ;
        }
        return jump[0] ;
    }
    
}