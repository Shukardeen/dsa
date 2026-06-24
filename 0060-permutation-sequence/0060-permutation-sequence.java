class Solution {
    public String getPermutation(int n, int k) {
        // answer string
        StringBuilder ans = new StringBuilder();
        // factorial variable
        int fact = 1;
        // arraylist to store n numbers
        List<Integer> nums = new ArrayList<>();

        // compute factorial till n-1 and add number to nums list
        for(int i=1; i<n; i++) {
            fact *= i;
            nums.add(i);
        }

        nums.add(n);
        // permutation will be found at k-1 index because of 0 based indexing
        k = k-1;

        // compute the permutation
        while(true) {
            ans.append(nums.get(k / fact));
            // delete the latest added element from nums
            nums.remove(k / fact);
            // break if nums size becomes 0
            if(nums.size() == 0) break;

            // update the value of k
            k = k % fact;
            // update the value of factorial
            fact = fact / nums.size();
        }

        return ans.toString();
    }
}