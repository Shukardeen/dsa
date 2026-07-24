class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // array to store prefix max of each building (previous building greater than building at i)
        int[] prefixMax = new int[n];
        // array to store suffix max (next building greater than building at i)
        int[] suffixMax = new int[n];

        // compute prefix max
        prefixMax[0] = height[0];
        for(int i=1; i<n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }

        // compute suffix max
        suffixMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        // compute total water trapped
        /*
        water on each building = Math.min(leftMax, rightMax) - height[building]
        */
        int totalWater = 0;
        for(int i=0; i<n; i++) {
            totalWater += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return totalWater;
    }
}