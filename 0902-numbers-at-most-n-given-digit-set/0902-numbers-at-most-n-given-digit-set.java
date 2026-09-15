class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] digs = new int[digits.length];
        for(int i=0;i<digits.length;i++){
            digs[i] = Integer.parseInt(digits[i]);
        }
        String r = String.valueOf(n);
        int len = r.length();
        int[][][] dp = new int[len][2][2];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1],-1);
        }
        return memo(r,0,1,1,digs,dp,len)-1;
    }
    public int memo(String num,int i,int lead,int tight,int[] digits,int[][][] dp,int n){
        if(i==n) return 1;
        if(dp[i][lead][tight]!=-1) return dp[i][lead][tight];
        int ub = tight==1?num.charAt(i)-'0':9;
        int count = 0;
        if(lead==1){
            count += memo(num,i+1,1,(tight==1&&ub==0)?1:0,digits,dp,n);
        }
        for(int dig:digits){
            if(dig<=ub){
                count += memo(num,i+1,0,(tight==1&&dig==ub)?1:0,digits,dp,n);
            }else{
                break;
            }
        }
        return dp[i][lead][tight]=count;
    }
}