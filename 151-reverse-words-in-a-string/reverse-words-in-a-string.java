class Solution {
    public String reverseWords(String s) {
        ArrayList<String> words = new ArrayList<>();
        int start = -1;
        int end = -1;
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)==' ')continue;
            if(start==-1) start = i;
            if(i==s.length()-1 || s.charAt(i+1)==' ') end = i;
            if(start!=-1 && end!=-1){
                words.add(s.substring(start ,end+1));
                end = -1;
                start = -1;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(String st : words){
            System.out.println(st);
        }
           for(int i=words.size()-1 ; i>=0 ; i--){
            
            sb.append(words.get(i));
            if(i!=0) sb.append(" ");
        }
        return sb.toString();
    }
}