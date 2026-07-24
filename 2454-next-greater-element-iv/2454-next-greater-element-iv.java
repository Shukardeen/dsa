class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        // monotonic stack to store indices of elements waiting for their first greater
        Deque<Integer> s1 = new ArrayDeque<>();

        // monotonic stack to store indices of elements waiting for their second greater
        Deque<Integer> s2 = new ArrayDeque<>();

        // temp stack to get elements of s1 in same order in s2
        Deque<Integer> temp = new ArrayDeque<>();

        // answer array to store nges
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // traverse
        for(int i=0; i<n; i++) {
            while(!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                ans[s2.pop()] = nums[i];
            }

            while(!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
                temp.push(s1.pop());
            }

            while(!temp.isEmpty()) s2.push(temp.pop());

            s1.push(i);
        }
        return ans;
    }
}