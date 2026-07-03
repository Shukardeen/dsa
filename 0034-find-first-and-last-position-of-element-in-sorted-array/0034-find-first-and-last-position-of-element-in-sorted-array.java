class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int lb = lowerBound(nums, target);
        if(lb == nums.length || nums[lb] != target) return new int[]{-1, -1};
        int ub = upperBound(nums, target);
        return new int[]{lb, ub-1};
    }

    // method to find lower bound
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        int lb = arr.length;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(arr[mid] >= target) {
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lb;
    }

    // method to find upper bound
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        int ub = arr.length;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(arr[mid] > target) {
                ub = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ub;
    }
}