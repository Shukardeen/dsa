class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int first = firstOccurence(nums, target);
        if(first == -1) return new int[]{-1, -1};
        int last = lastOccurence(nums, target);
        return new int[]{first, last};
    }

    // method to find first occurence
    private int firstOccurence(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        int first = -1;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        return first;
    }

    // method to find last occurence
    private int lastOccurence(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        int last = arr.length;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
}