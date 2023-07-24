class Solution {
    class Pair{
        String str;
        int level;
        Pair(String str , int level){
            this.str = str;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(String s : wordList) set.add(s);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(q.size()!=0){
            Pair removed = q.remove();
            if(removed.str.equals(endWord)) return removed.level;
            
            // check for its childeren 
            //find every possible 3 digit letter and check if it is present in my stack
            // if yes then it is my children
            check(removed,q,set,visited); // this function will add removed's correct childrens
        }
        return 0;
    }
    public void check(Pair parent,Queue<Pair> q,HashSet<String> set,HashSet<String> visited){
       
        for(int i=0;i<parent.str.length();i++){
             StringBuilder sb = new StringBuilder(parent.str);
            for(int j=0;j<26;j++){
                char newChar = (char) ('a'+ j);
                sb.setCharAt(i, newChar);
                String newWord = sb.toString();
                if(set.contains(newWord) && !visited.contains(newWord)){
                    q.add(new Pair(sb.toString(),parent.level+1));
                    visited.add(newWord);   
                }
            }
        }
    }
}