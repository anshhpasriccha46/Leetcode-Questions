class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m*k) return -1;

        int h = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;
        for(int i: bloomDay){
            h = Math.max(h , i);
            l = Math.min(l , i);
        }
        int ans = -1;
        while(l<h){
            int mid = l + (h - l)/2;
            int count = 0;
            int soFar = 0;
            for(int i=0  ; i<bloomDay.length ; i++){
                if(bloomDay[i]<=mid){
                    soFar++;
                }
                else soFar = 0;
                if(soFar==k){ 
                count++;
                soFar = 0;
                }
            }
            
            if(count>=m){
                h = mid ;
            }
            else{
                l = mid + 1;
            }
        }

        return h;
        
    }
}