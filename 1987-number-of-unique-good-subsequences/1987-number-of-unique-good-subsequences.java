class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int mod = (int) 1e9 + 7;
        int endsWithZero = 0;
        int endsWithOne = 0;
        int seenZero = 0;

        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '0') {
                endsWithZero = (endsWithZero + endsWithOne) % mod;
                seenZero = 1;
            } else {
                endsWithOne = (endsWithZero + endsWithOne + 1) % mod;
            }
        }

        return (endsWithZero + endsWithOne + seenZero) % mod;
    }
}