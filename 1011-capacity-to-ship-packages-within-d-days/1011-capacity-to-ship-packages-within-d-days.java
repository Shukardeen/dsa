class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // find the maximum weight that is the minimum capacity of ship required to load the max weight product
        // find the sum of all weights that is the maximum capacity of ship required to load all the weights at once
        int low = 0, high = 0;
        for(int weight: weights) {
            if(weight > low) low = weight;
            high += weight;
        }

        // implement binary search
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(findDays(weights, mid) <= days) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // method to find the number of days a ship of capacity "c" will take to convey all weights
    private int findDays(int[] weights, int c) {
        int days = 1;
        int load = 0;
        for(int weight: weights) {
            if(load + weight > c) {
                days++;
                load = weight;
            } else {
                load += weight;
            }
        }
        return days;
    }
}