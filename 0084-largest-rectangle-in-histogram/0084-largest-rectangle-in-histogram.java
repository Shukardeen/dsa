class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // arrays to store nse and pse
        int[] nse = new int[n];
        int[] pse = new int[n];

        findNse(heights, nse);
        findPse(heights, pse);

        // find area
        int area = 0;
        for(int i=0; i<n; i++) {
            int width = nse[i]-pse[i]-1;
            area = width*heights[i] > area ? width*heights[i] : area;
        }
        return area;

    }
    // method to find nse
    private void findNse(int[] arr, int[] nse) {
        int n = arr.length;
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        // traverse
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    // method to find pse
    private void findPse(int[] arr, int[] pse) {
        int n = arr.length;
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        // traverse
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }
}