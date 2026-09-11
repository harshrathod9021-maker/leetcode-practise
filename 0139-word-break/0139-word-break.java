// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Map<String, Boolean> memo = new HashMap<>();
//         Set<String> wordSet = new HashSet<>(wordDict);
//         return dfs(s, wordSet, memo);
//     }
    
//     private boolean dfs(String s, Set<String> wordSet, Map<String, Boolean> memo) {
//         if (memo.containsKey(s)) return memo.get(s);
//         if (wordSet.contains(s)) return true;
//         for (int i = 1; i < s.length(); i++) {
//             String prefix = s.substring(0, i);
//             if (wordSet.contains(prefix) && dfs(s.substring(i), wordSet, memo)) {
//                 memo.put(s, true);
//                 return true;
//             }
//         }
//         memo.put(s, false);
//         return false;
//     }
// }






















class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        // dp[i] = true if first i characters can be formed
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (String word : wordDict) {

                int len = word.length();

                if (i >= len && dp[i - len]) {

                    if (s.substring(i - len, i).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}