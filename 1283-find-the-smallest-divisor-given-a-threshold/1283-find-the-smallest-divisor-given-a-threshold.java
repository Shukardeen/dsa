class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = nums[0];
        // find the greatest number in array that is the greatest divisor
        for(int num: nums) {
            if(num>high) high = num;
        } 

        // implement binary search
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(divisionSum(nums, mid) <= threshold) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    // method to get division sum
    private int divisionSum(int[] arr, int divisor) {
        int sum = 0;
        for(int num: arr) {
            sum += (num+divisor-1)/divisor;
        }
        return sum;
    }
}