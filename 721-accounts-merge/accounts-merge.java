import java.util.*;
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String , HashSet<String>> map = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        //HashSet<String> allEmails = new HashSet<>();
        for(int i=0 ; i<accounts.size() ; i++){
            String name = accounts.get(i).get(0);
            emailToName.put(accounts.get(i).get(1) , name);

            if(!map.containsKey(accounts.get(i).get(1) )){
                HashSet<String> nodes = new HashSet<>();
                map.put(accounts.get(i).get(1) , nodes);
            }
            for(int j=2 ; j<accounts.get(i).size() ; j++){
                if(!map.containsKey(accounts.get(i).get(j))){
                     emailToName.put(accounts.get(i).get(j) , name);
                    map.put(accounts.get(i).get(j) , new HashSet<>());
                }
                map.get(accounts.get(i).get(1)).add(accounts.get(i).get(j));
                map.get(accounts.get(i).get(j)).add(accounts.get(i).get(1));
            }
        }
        HashSet<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();
        List<String> entry= new ArrayList<>();
        for(String emails : map.keySet()){
            if(vis.contains(emails)) continue;
                q.add(emails);
                vis.add(emails);
                 entry = new ArrayList<>();
                entry.add(emailToName.get(emails));
                entry.add(emails);
            
            while(!q.isEmpty()){
                String parEmail = q.poll();
                for(String childEmail : map.get(parEmail)){
                    if(!vis.contains(childEmail)){
                        vis.add(childEmail);
                        q.add(childEmail);
                        entry.add(childEmail);
                    }
                }
            
            }
            Collections.sort(entry.subList(1  ,entry.size()));
            ans.add(entry);
        }
        
        return ans;
    }
}