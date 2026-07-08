class Solution {
    public int splitArray(int[] nums, int k) {
        // step1: find the range of the min and max sum
        int low = 0;
        int high = 0;
        for(int num: nums) {
            if(num > low) low = num;
            high += num;
        }

        while(low<=high) {
            int mid = low+(high-low)/2;
            if(isPossible(nums, mid, k)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    // method to find if array can be splitted in k halves with the given max value 
    private boolean isPossible(int[] nums, int max, int k) {
        int sum = 0;
        int halves = 1;
        for(int num: nums) {
            if(sum+num <= max) {
                sum += num;
            } else {
                halves++;
                sum = num;
            }
        }
        return halves <= k;
    }
}