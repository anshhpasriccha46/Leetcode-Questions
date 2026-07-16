import java.util.*;
class Pair{
    int num;
    int freq;
    Pair(int a, int b){
        num = a;
        freq = b;
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int gs) {
        if(hand.length % gs !=0) return false;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b)->{
            return a.num- b.num;
        });
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i: hand){
            mp.put(i , mp.getOrDefault(i , 0) + 1);
        }
        for(int i: mp.keySet()){
            pq.add(new Pair(i , mp.get(i)));
        }
        Queue<Pair> q= new LinkedList<>();
        int count = 0; 
        int prev = pq.peek().num-1;
        while(!pq.isEmpty() || !q.isEmpty()){
            if(pq.size() == 0) return false;
            if(!pq.isEmpty())
            {Pair temp = pq.poll();
            temp.freq--;
            //  System.out.println(temp.num +" "+ prev);
            if(temp.num!=prev+1) return false;
            prev = temp.num;
            
            if(temp.freq!=0) q.add(temp);
           
            count++;
            // System.out.println("Count: " + count );
            //  System.out.println("Size: " + q.size() );

            }
            if(count==gs){
                while(!q.isEmpty()){
                    pq.add(q.poll());
                }
                if(pq.size() == 0) return true;
                prev = pq.peek().num - 1;
                count = 0;
                //  System.out.println("One Set DONE!!!");
                // System.out.println("Now Prev is:" + prev);
                
            }

        }

        return true;
        

    }
}