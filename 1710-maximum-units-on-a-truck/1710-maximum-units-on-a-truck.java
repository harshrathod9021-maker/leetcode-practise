class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int n = boxTypes.length;
        int size = truckSize;
        int unit = 0;

        for(int i = 0; i < n; i++){
            if(boxTypes[i][0] <= size){
                size = size - boxTypes[i][0];
                unit += boxTypes[i][0] * boxTypes[i][1];
            }
            else {
                unit += boxTypes[i][1] * size;
                break;
            }
        }
        return unit;
    }
}