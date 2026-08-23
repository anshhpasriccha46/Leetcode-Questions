class Solution {
    public int trap(int[] height) {
        //if(height.length == 1) return 0;
        int  l = -1;
        
        for(int i=0 ; i<height.length ; i++){
            if(height[i]!=0){
                 l = i;
                 break;
            }
        }
        if(l==-1) return 0;
        int r = find(height , l);
        int amt = 0;
        while(r!=-1){
            int min = Math.min(height[l] , height[r]);
            int i = l+1;
            while(i<r){
                amt+=(min - height[i]);
                i++;
            }
            l = r;
            r = find(height , r);
            
        }
        return amt;
    }
    public int find(int height[] , int r){
        int l = r;
        int potential = -1;
        int comp = height[l];
        for(int i=l+1 ; i<height.length ; i++){
            if(height[i]!=0) {
            potential = i;
             break;
             }
        }
        for(int i = l+1 ; i<height.length ; i++){
            if(height[i] != 0){
                if(height[potential] <= height[i]) potential = i;
                if(height[i]>=height[l]) break;
            }
        }
        return potential;
    }
}