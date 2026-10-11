class Solution {
    public String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        char a[] = s.toCharArray();
        char b[] = t.toCharArray();
        
        int size = Integer.MAX_VALUE;
        int start = -1;
        int end= -1;

        HashMap<Character , Integer> m = new HashMap<>();
        HashMap<Character , Integer> l = new HashMap<>();
        for(char c : b){
            m.put(c , m.getOrDefault(c , 0) + 1);
            l.put(c , l.getOrDefault(c , 0) + 1);

        }
        int r = 0;
        int left = 0;
        int missing = t.length();

         while(r < a.length){
           
            if(l.containsKey(a[r])){
                if(m.get(a[r]) > 0) missing--;
                 m.put(a[r] , m.get(a[r]) - 1 );
             

            }
            if(missing==0){
                
                
                  //System.out.println(s.substring(left , r + 1));
                while(missing==0){
                    if(size>r - left+1){
                    size = r - left + 1;
                    start = left;
                    end = r;
                  
                }
                    if(l.containsKey(a[left])){
                        
                        m.put(a[left] , m.getOrDefault(a[left] , 0) + 1);
                        if(m.get(a[left]) > 0) missing++;
                        
                    }
                    left++;
                    
                }
                
               
            }
            r++;
        }
        if(start==-1 || end == -1) return "";
        String answer = s.substring(start , end + 1);
        return answer;
    }
}