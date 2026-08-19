import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        // HashSet<Integer> s = new HashSet<>();
        // for(int i: nums){
        //     if(s.contains(i)) return i;
        //     s.add(i);
        // }
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length-1 ; i++){
            if(nums[i]==nums[i+1]) return nums[i];
        }
        return -1;
    }
}