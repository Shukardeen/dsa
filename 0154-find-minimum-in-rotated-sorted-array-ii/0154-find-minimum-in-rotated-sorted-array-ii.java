class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int low = 0;
        int high = nums.length-1;
        int minimum = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low+(high-low)/2;
            // check if arr[low], arr[mid], and arr[high] are equal
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                // if true, shrink the search space by low+1 and high-1 and continue
                minimum = Math.min(minimum, nums[low]);
                low = low+1;
                high = high-1;
                continue;
            }
            // check if the left half is sorted 
            if(nums[low] <= nums[mid]) {
                // if yes, pick the minimum from left half
                minimum = Math.min(minimum, nums[low]);
                // eliminate the left half
                low = mid + 1;
            } else {
                // if left half is not sorted then right half will definitely be sorted
                // pick minimum from right half
                minimum = Math.min(minimum, nums[mid]);
                // eliminate the right half
                high = mid - 1;
            }
        }
        // return the minimum values
        return minimum;
    }
}