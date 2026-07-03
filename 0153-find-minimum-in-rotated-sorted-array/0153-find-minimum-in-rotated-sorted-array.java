class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0, high = nums.length-1, ans = Integer.MAX_VALUE;

        while(low<=high) {
            int mid = low+(high-low)/2;
            // check if the search space is sorted or not
            // if yes, pick the minimum and break binary search
            if(nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            // check if the left half is sorted
            if(nums[low] <= nums[mid]) {
                // if yes, pick the minimum and eliminate left half
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            } else {
                // if left is not sorted, it is guaranteed that right half is sorted, then pick minimum element from right half and eliminate it
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        // return answer
        return ans;
    }
}