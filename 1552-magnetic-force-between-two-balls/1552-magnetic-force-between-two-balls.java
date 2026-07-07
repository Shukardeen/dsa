class Solution {
    public int maxDistance(int[] position, int m) {
        // binary search approach
        // step1: sort the array
        Arrays.sort(position);

        // step2: find the max possible distance between balls
        int min = position[0];
        int max = position[position.length-1];
        // implement binary search on the range of possible distances is 1 to max-min
        int low = 1;
        int high = max-min;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(canPlace(position, mid, m)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }

    // method to find if all the balls can be placed on positions while maintaining the given minimum distance
    private boolean canPlace(int[] positions, int distance, int m) {
        int ballCount = 1;
        int last = positions[0];
        for(int i=1; i<positions.length; i++) {
            if(positions[i]-last >= distance) {
                ballCount++;
                last = positions[i];
                if(ballCount == m) return true;
            }
        }
        return false;
    }
}