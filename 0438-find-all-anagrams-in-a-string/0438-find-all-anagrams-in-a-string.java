class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int plen = p.length();
        List<Integer> k = new ArrayList<>();
        boolean n;
        for(int i = 0;i<=s.length()-plen;i++){
            n = isanagram(s.substring(i,i+plen),p);
            if(n){
                k.add(i);
            }
        }
        return k;
        
    }

    private boolean isanagram(String k,String p){
         if (k.length() != p.length()) {
            return false;
        }
        int[] count = new int[26];

        for (int i = 0; i < k.length(); i++) {
            count[k.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}