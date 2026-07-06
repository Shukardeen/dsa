class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find the max element in piles that is the maximum number of bananas that can be eaten per hour
        int low = 1, high = piles[0];
        for(int pile: piles) {
            if(pile > high) high = pile;
        }

        // implement binary search to find the minimum bananas to be eaten per hour to eat all bananas in given hours
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(time(piles, mid) <= h) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    // method to find the total hours koko will take to eat all bananas when k number of bananas are eaten per hour
    private int time(int[] piles, int k) {
        int totalHours = 0;
        for(int pile: piles) {
            totalHours += Math.ceil((double) pile/k);
        }
        return totalHours;
    }
}