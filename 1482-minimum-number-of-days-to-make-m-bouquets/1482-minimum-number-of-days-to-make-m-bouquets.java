class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long flowers = (long)m * (long)k;
        if(bloomDay.length < flowers) return -1;
        // find the minimum and maximum day a flower can take to bloom
        int low = bloomDay[0];
        int high = bloomDay[0];
        for(int day: bloomDay) {
            if(day < low) low = day;
            if(day > high) high = day;
        }

        // implement binary search
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(isPossible(bloomDay, mid, m, k)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    // method to find if m bouquets can be made on a day or not
    private boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int nOfB = 0;
        for(int bday: bloomDay) {
            if(bday <= day) count++;
            else {
                nOfB += count/k;
                count = 0;
            }
        }
        nOfB += count/k;
        return nOfB >= m;
    }
}