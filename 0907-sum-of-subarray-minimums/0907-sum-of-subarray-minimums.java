class Solution {
    final int MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // array to store pse
        int[] pse = new int[n];
        // array to store nse
        int[] nse = new int[n];

        // compute pse and nse
        findPse(arr, pse);
        findNse(arr, nse);

        // find sum of subarray minimums
        long sum = 0;
        for(int i=0; i<n; i++) {
            long left = i-pse[i];
            long right = nse[i]-i;
            sum += (left*right*arr[i]);
            sum %= MOD;
        }
        return (int) sum;
    }

    // method to find pse
    private void findPse(int[] arr, int[] pse) {
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    // method to find nse
    private void findNse(int[] arr, int[] nse) {
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
    }
}