class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] x : intervals) {
            list.add(x);
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] <= list.get(i - 1)[1]) {
                list.get(i)[0] = list.get(i - 1)[0];
                list.get(i)[1] = Math.max(
                        list.get(i)[1],
                        list.get(i - 1)[1]
                );
                list.remove(i - 1);

                i--;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}