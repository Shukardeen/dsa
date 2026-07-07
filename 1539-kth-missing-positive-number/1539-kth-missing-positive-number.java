class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = k;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= missing) missing++;
            else break;
        }
        return missing;
    }
}