class Solution {
    public int getMinSwaps(String num, int k) {
        char arr[] = num.toCharArray();
        char crr[] = num.toCharArray();
        while(k-- > 0){
            permute(arr);
        }
        
        return countSteps(arr, crr, arr.length) ;
    }
     public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
    private int countSteps(char []s1, char[] s2, int size) {
        int i = 0, j = 0;
        int count = 0;

        while (i < size) {
            j = i;

            while (s1[j] != s2[i]) {
                j += 1;
            }
            while (i < j) {
                swap(s1, j, j - 1);
                j -= 1;
                count++;
            }
            i++;
        }
        return count;
    }
    public void permute(char arr[]){
        
        int idx = -1 ;
        for(int i = arr.length-2 ; i >= 0 ; i--){
            if(arr[i] < arr[i+1]){
                idx = i ;
                break ;
            }
        }
        if(idx != -1){
            for(int i = arr.length-1 ; i > idx ; i--){
                if(arr[i] > arr[idx]){
                    char t = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = t ;
                    break ;
                }
            }
        }
        reverse(arr, idx+1, arr.length-1);
    }
    public void reverse(char arr[], int left , int right){
        while(left < right){
            char t = arr[left];
            arr[left++] = arr[right];
            arr[right--] = t ;
        }
    }
}