import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i: nums){
            if(s.contains(i)) return i;
            s.add(i);
        }
        return -1;
    }
}