class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int dely = (coordinates[1][1]-coordinates[0][1]);
        int delx = (coordinates[1][0]-coordinates[0][0]) ;
        
        for(int i = 2 ; i < coordinates.length ; i++){
            int dy = (coordinates[i][1]-coordinates[i-1][1]);
            int dx = (coordinates[i][0]-coordinates[i-1][0]);
            if(dely*dx != delx*dy)return false ;
        }
        
        return true ;
    }
}