class Solution {
    public boolean isPalindrome(String s) {
        String new1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int n = new1.length();
        int i = 0;
        int j = new1.length()-1;
        while(i<new1.length()/2){
            if(new1.charAt(i) != new1.charAt(n - i - 1)){
                return false;

                
            }
            i++;
            j--;
        }
        return true;
    }
}