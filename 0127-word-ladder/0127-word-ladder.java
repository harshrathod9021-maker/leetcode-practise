class Solution {
    class node{
        String word;
        int c ;
        node(String word , int  c){
            this.word = word;
            this.c = c;

        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }

        Queue<node> qu = new LinkedList<>();

        node src = new node(beginWord,1);
        qu.offer(src);
        set.remove(beginWord);
        while(!qu.isEmpty()){
            node cur = qu.poll();
            String w = cur.word;
            int c = cur.c;
            if(w.equals(endWord)) return c ;
            

            for(int i = 0 ; i < w.length();i++){
                for(char k = 'a' ;k <='z'; k ++){
                    char [] kooo = w.toCharArray();
                    kooo[i]=k;
                    String sss = new String(kooo);
                    if(set.contains(sss)){
                        qu.add(new node(sss,c+1));
                        set.remove(sss);
                    }
                }
            }
             
        }
        return 0;
        
    }
}