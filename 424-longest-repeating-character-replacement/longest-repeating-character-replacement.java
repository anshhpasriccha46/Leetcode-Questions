class Solution {
    public int characterReplacement(String s, int k) {
        int[] frq = new int[26];
        int l=0;
        int r=0;
        int maxFreq = 0;
        int maxLen = 0;

        while(r<s.length()){
            frq[s.charAt(r) - 'A']++;
             maxFreq = Math.max(maxFreq  , frq[s.charAt(r) - 'A']);
             while(r-l+1 - maxFreq > k){
                frq[s.charAt(l) -'A']--;
                maxFreq = Math.max(maxFreq  , frq[s.charAt(r) - 'A']);
                l++;
             }
             maxLen = Math.max(maxLen , r-l+1);
             r++; 
        }
        return maxLen;
    }
}