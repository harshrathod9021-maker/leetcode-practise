class Solution {

    private void subsets(int idx, List<List<Integer>> ans,
                         List<Integer> list, int[] nums) {

        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {

            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            subsets(i + 1, ans, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        subsets(0, ans, new ArrayList<>(), nums);

        return ans;
    }
}