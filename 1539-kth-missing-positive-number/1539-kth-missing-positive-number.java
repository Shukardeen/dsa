class Solution {
    public int findKthPositive(int[] arr, int k) {
        // brute force solution
        /*
        int missing = k;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= missing) missing++;
            else break;
        }
        return missing;
        */

        // optimal solution - using binary search
        int low = 0, high = arr.length-1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(arr[mid]-(mid+1) < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low+k;
    }
}