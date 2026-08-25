class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        if(n == 0){
            return ;
        }

        int st = 0;
        int e = n-1;
        while(st<e){
            char temp = s[st];
            s[st] = s[e];
            s[e] = temp;
            st++;
            e--;
        }

        for(char c : s){
            System.out.println(c);
        }
        
    }
}