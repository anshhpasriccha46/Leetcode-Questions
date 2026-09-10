class Solution {
    public List<List<String>> partition(String s) {
       
        List<List<String>> sol = new ArrayList<>();
        List<String> ans  = new ArrayList<>();
       
        kar(sol , ans, s , 0);
        return sol;
    }
    public void kar( List<List<String>> sol ,List<String> ans, String s , int index){
        if(index==s.length()){
            sol.add(new ArrayList<>(ans));
            return;
        }
        for(int i=index ; i<s.length() ; i++){
            if(!isit(s.substring(index , i+1))) continue;
            ans.add(s.substring(index , i+1));
            kar(sol, ans , s , i+1);
            ans.remove(ans.size() - 1);
        }

    }
    public boolean isit(String a){
        int l=0;
        int h = a.length()-1;
        while(l<h){
            if(a.charAt(l)!=a.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}