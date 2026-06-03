import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        boolean found  =  false;
        boolean isThere = false;
        ArrayList<ArrayList<String>> g = new ArrayList<>();
        int index = 0;
        for(String str: wordList){
            if(str.length() != n ) return 0;
            if(str.equals(endWord)) found = true;
           
        }
        for(int i=0 ; i<wordList.size()  ; i++){
            if(wordList.get(i).equals(beginWord)){
                isThere = true;
                wordList.remove(i);
                 wordList.add(0 , beginWord);
            }
        }
        if(!found) return 0;
        HashMap<String , Integer> map = new HashMap<>();
        // map.put(beginWord , 0);
      
        if(!isThere)  wordList.add(0 , beginWord);
          for(String str: wordList){
            map.put(str , map.size());
        }
        for(int i=0 ;  i<wordList.size(); i++){
            g.add(new ArrayList<>());
        }

        for(int i=0 ; i<wordList.size() ; i++){
            for(int j=i+1 ; j<wordList.size() ; j++){
                if(check(wordList.get(i) , wordList.get(j))){
                  g.get(map.get(wordList.get(i))).add(wordList.get(j));
                  g.get(map.get(wordList.get(j))).add(wordList.get(i));
                }
            }
        }
        for(ArrayList<String> strs : g){
            for(String str: strs){
                System.out.print(str  +  " ");
            }
            System.out.println();
        }
        for(String str: wordList){
            System.out.print(str+" ");
        }
        if( g.get(map.get(beginWord)).size() == 0) return 0;
        return BFS(beginWord , g , map , endWord) + 1;

    }
    public boolean check(String s1 , String s2){
        boolean found = false;
        for(int i=0  ; i<s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i) && !found){
                found = true;
            }
            else if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;

    }
    public int BFS( String stword , ArrayList<ArrayList<String>> g , HashMap<String  , Integer> m , String finWord ){
        boolean[] visited = new boolean[g.size()];
        visited[0] = true;
        Queue<String> q = new LinkedList<>();
        q.add(stword);
        
        int count = 0;
        while(!q.isEmpty()){
          
            int size = q.size();
            
            count++;
          
            for(int i=0 ; i<size ; i++){
            String temp = q.poll();
            visited[m.get(temp)] = true;
            for(String str: g.get(m.get(temp))){
                
                if(str.equals(finWord) ){
                    
                    return count;
                }
               if(!visited[m.get(str)]) q.add(str);

            }
           
        }
        }
        return -1;
    }
}