class Solution {
    public int longestCycle(int[] edges) {
        int[] a=new int[edges.length];
        int t=1,ans=-1;
        for(int i=0;i<edges.length;i++){
            if(a[i]!=0) continue;
            int s=t;
            int curr=i;
            while(curr!=-1 && a[curr]==0){
                a[curr]=t++;
                curr=edges[curr];
            }
            if(curr!=-1 && a[curr]>=s){
                ans=Math.max(ans,t-a[curr]);
            }
        }
        return ans;
    }
}