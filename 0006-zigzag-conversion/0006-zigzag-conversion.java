class Solution {
    public String convert(String s, int numRows) {
        StringBuilder arr[] = new StringBuilder[numRows];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = new StringBuilder();
        }
        
        boolean forward = true ;
        boolean backward = false ;
        int idx =0 ;
        for(int i =0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            arr[idx].append(ch);
            if(forward)idx++ ;
            if(backward)idx-- ;
            if(idx == arr.length){
                forward = false ;
                backward = true ;
                idx -= 2 ;
            }
            if(idx == -1){
                forward = true ;
                backward = false ;
                idx = (idx+2)%arr.length ;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i =0 ;  i < arr.length ;i++){
            // System.out.println(arr[i]);
            ans.append(arr[i].toString());
        }
        return ans.toString();
    }
}