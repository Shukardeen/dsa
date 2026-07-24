class Solution {
    public long subArrayRanges(int[] nums) {
        return sumOfMaximums(nums)-sumOfMinimums(nums);
    }

    // sum of subarray minimums
    private long sumOfMinimums(int[] arr) {
        int n = arr.length;
        // array to store nse and pse
        int[] nse = new int[n];
        int[] pse = new int[n];

        // find nse and pse
        findNse(arr, nse);
        findPse(arr, pse);

        // sum
        long sum = 0;
        for(int i=0; i<n; i++) {
            long left = i-pse[i];
            long right = nse[i]-i;
            sum += (left*right*arr[i]);
        }
        return sum;
    }

    // method to find nse
    private void findNse(int[] arr, int[] nse) {
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        // traverse
        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
    }

    // method to find pse
    private void findPse(int[] arr, int[] pse) {
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    // sum of subarray maximums
    private long sumOfMaximums(int[] arr) {
        int n = arr.length;

        // arrays to store nge and pge
        int[] nge = new int[n];
        int[] pge = new int[n];

        // compute nge and pge
        findNge(arr, nge);
        findPge(arr, pge);

        // compute sum
        long sum = 0;
        for(int i=0; i<n; i++) {
            long left = i-pge[i];
            long right = nge[i]-i;
            sum += (left*right*arr[i]);
        }
        return sum;
    }

    // method to find nge
    private void findNge(int[] arr, int[] nge) {
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
    }

    // method to find pge
    private void findPge(int[] arr, int[] pge) {
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }
}