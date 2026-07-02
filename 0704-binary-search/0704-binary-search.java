class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && target == nums[0]) return 0;
        else if(nums.length == 1) return -1;

        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}