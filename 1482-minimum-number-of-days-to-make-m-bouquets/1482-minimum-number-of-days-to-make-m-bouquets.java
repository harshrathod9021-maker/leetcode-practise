class Solution {
    public static int getmin(int boolmDay[]){
        int Min_Value = Integer.MAX_VALUE;
        for (int i =0; i< boolmDay.length; i++){
            Min_Value = Math.min(boolmDay[i],Min_Value);
        }
        return Min_Value;
    }
    public static int getmax(int boolmDay[]){
        int max = Integer.MIN_VALUE;
        for(int i =0; i< boolmDay.length ;i++){
            max = Math.max(boolmDay[i],max);
        }
        return max;
    }
    public static boolean Checking(int boolmDay[],int k,int mid,int m){
        int flowers = 0;
        int bouquets = 0;

      for(int i =0; i < boolmDay.length ; i++){
        if (boolmDay[i] <= mid) flowers++;
        else flowers = 0;
         if (flowers==k) {
             bouquets++; 
             flowers=0;
             }
      }
      return bouquets>=m;
    }
        
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) bloomDay.length < m*k) return -1;

      int low = getmin(bloomDay);
     int high = getmax(bloomDay);
      int ans = -1;
      while (low <=high){
        int  mid = low+(high-low)/2;
        if(Checking(bloomDay,k,mid,m))
        {
            ans = mid;
            high = mid-1;
        }
        else
            low=mid+1;
        
      }
      return ans;

    }
}