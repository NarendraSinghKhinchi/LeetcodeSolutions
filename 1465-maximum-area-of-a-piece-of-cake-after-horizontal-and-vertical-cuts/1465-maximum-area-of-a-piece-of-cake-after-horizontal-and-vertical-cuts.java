class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hr = 0;
        int vr = 0 ;
        int prev = 0 ;
        for(int x : horizontalCuts){
            hr = Math.max(hr , x-prev);
            prev = x ;
        }
        hr = Math.max(hr , h-prev);
        prev = 0 ;
        for(int x:verticalCuts){
            vr = Math.max(vr , x-prev);
            prev = x ;
        }
        vr = Math.max(vr , w-prev);
        int mod = (int)1e9+7 ;
        long ans = ((long)hr*(long)vr)%mod ;
        return (int)ans ;
    }
}