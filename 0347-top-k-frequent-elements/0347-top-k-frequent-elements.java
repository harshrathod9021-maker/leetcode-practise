class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0) + 1);
        }

        ArrayList<Map.Entry<Integer,Integer>> arr =
                new ArrayList<>(hm.entrySet());

        arr.sort((a,b)->b.getValue()-a.getValue());
        int[] last = new int[k];
        for(int i=0;i<k;i++){
            last[i]=arr.get(i).getKey();
        }
        return last;

        
    }
}