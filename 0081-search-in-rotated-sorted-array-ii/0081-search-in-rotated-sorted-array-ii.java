class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid] == target) return true;
            // check if arr[low], arr[mid], and arr[high] are equal
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low+1;
                high = high-1;
                continue;
            }
            // check if left half is sorted
            if(nums[low] <=nums[mid]) {
                // check if target lies in sorted left half
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return false;
    }
}