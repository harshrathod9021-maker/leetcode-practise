import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        int i = 0;
        int max = 0;

        for (int j = 0; j < s.length(); j++) {

            char ch = s.charAt(j);

            if (hm.containsKey(ch)) {
                i = Math.max(i, hm.get(ch) + 1);
            }

            hm.put(ch, j);

            int cm = j - i + 1;
            max = Math.max(max, cm);
        }

        return max;
    }
}