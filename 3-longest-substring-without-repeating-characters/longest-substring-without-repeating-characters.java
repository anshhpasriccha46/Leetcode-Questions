class Solution {
    public int lengthOfLongestSubstring(String s) {
        char a[] =s.toCharArray();
        int count = 0;
        int r = 0;
        int l=0;
        int max = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        while(r<a.length){
            map.put(a[r] , map.getOrDefault(a[r] , 0) + 1);
            if(map.get(a[r])<2) {
                count++;
                // for(int k=l ; k<=r ; k++){
                //     System.out.print(a[k]);
                // }
                //  System.out.print(count);
                // System.out.println();
                max = Math.max(max , count);
            }
           
            while(map.get(a[r])>1){
                if(map.get(a[l])==1) map.remove(a[l]);
                else
                map.put(a[l] , map.get(a[l]) - 1);
                l++;
                count = r - l + 1;
            }
            r++;
        }
        return max;
    }
}