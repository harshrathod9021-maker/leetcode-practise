// import java.util.*;

// class Solution {

//     public String minWindow(String s, String t) {

//         Map<Character, Integer> tMap = new HashMap<>();

//         // Store frequency of characters in t
//         for (char c : t.toCharArray()) {
//             tMap.put(c, tMap.getOrDefault(c, 0) + 1);
//         }

//         String ans = "";

//         for (int i = 0; i < s.length(); i++) {

//             Map<Character, Integer> windowMap = new HashMap<>();

//             for (int j = i; j < s.length(); j++) {

//                 char ch = s.charAt(j);

//                 // Add current character to window
//                 windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

//                 // Check if current window is valid
//                 if (isValid(windowMap, tMap)) {

//                     String sub = s.substring(i, j + 1);

//                     if (ans.equals("") || sub.length() < ans.length()) {
//                         ans = sub;
//                     }
//                 }
//             }
//         }

//         return ans;
//     }


//     private boolean isValid(
//             Map<Character, Integer> windowMap,
//             Map<Character, Integer> tMap) {

//         for (char c : tMap.keySet()) {

//             // Character not present or frequency is less
//             if (windowMap.getOrDefault(c, 0) < tMap.get(c)) {
//                 return false;
//             }
//         }

//         return true;
//     }
// } gives TLE

import java.util.*;

class Solution {

    public String minWindow(String s, String t) {

        // Store frequency of characters in t
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Store frequency of characters in current window
        Map<Character, Integer> sMap = new HashMap<>();

        int left = 0;
        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        String ans = "";

        // Expand the window using right pointer
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Add current character to window
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            // If this character is needed
            if (tMap.containsKey(ch) && sMap.get(ch) <= tMap.get(ch)) {
                count--;
            }

            // When all characters of t are present
            while (count == 0) {

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }

                // Remove left character
                char leftChar = s.charAt(left);

                sMap.put(leftChar, sMap.get(leftChar) - 1);

                // Check if removing this character makes window invalid
                if (tMap.containsKey(leftChar)
                        && sMap.get(leftChar) < tMap.get(leftChar)) {
                    count++;
                }

                // Shrink window
                left++;
            }
        }

        return ans;
    }
}