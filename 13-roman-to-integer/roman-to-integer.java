import java.util.*;
class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Integer> m = new HashMap<>();
       
m.put('I', 1);
m.put('V', 5);
m.put('X', 10);
m.put('L', 50);
m.put('C', 100);
m.put('D', 500);
m.put('M', 1000);
        int i=0;
        int ans = 0;
        while(i<s.length()){
            if(i!=s.length()-1 && m.get(s.charAt(i+1))>m.get(s.charAt(i))) ans-=m.get(s.charAt(i));
            else ans+=m.get(s.charAt(i));
            i++;
        }
        return ans;
    }
}