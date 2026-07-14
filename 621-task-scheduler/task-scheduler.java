import java.util.*;
class pair{
    char t;
    int  freq;
    int at;
    pair(char a  , int b , int c){
        t  = a;
        freq = b;
        at = c;
    }

}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character , Integer> mp = new HashMap<>();
        for(char c: tasks){
            mp.put(c , mp.getOrDefault(c , 0) + 1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            return b.freq - a.freq;
        });
        for(char c  : mp.keySet()){
            pair a = new pair(c , mp.get(c) , 0);
            pq.add(a);
        }
      
        Queue<pair> q = new LinkedList<>();
       
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                pair temp = pq.poll();
                temp.freq--;
                if(temp.freq>0){
                    temp.at = time + n;
                    q.add(temp);
                }
            }
            
            if(!q.isEmpty() && q.peek().at == time){
                    pair temp = q.poll();
                    pq.add(temp);
            }
        }


        return time;
    }
}