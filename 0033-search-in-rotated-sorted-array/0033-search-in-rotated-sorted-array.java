class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid] == target) return mid;
            // check if left half is sorted
            if(nums[low] <= nums[mid]) {
                // if sorted, check if target lies in left half
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // if left half is not sorted, then right half will definitely be sorted
            else {
                // check if target lies in right half
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        // return -1 if element not found
        return -1;
    }
}