class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        // monotonic stack to store elements in decreasing order
        Deque<Integer> st = new ArrayDeque<>();

        // array to store nge
        int[] nge = new int[n];

        // traverse the array that is double size of nums (hypothetical)
        for(int i=(2*n-1); i>=0; i--) {
            int num = nums[i%n];
            while(!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }
            if(i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(num);
        }
        return nge;
    }
}