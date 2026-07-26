class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // step 1: find prefix sum matrix
        int[][] psm = findPsm(matrix, n, m);

        // step 2: find largest rectangle in each histogram of psm
        int maxArea = 0;
        for(int i=0; i<n; i++) {
            int area = findLargestRectangle(psm[i]);
            maxArea = area > maxArea ? area : maxArea;
        }
        return maxArea;
    }

    // method to find prefixSum matrix (the histograms)
    private int[][] findPsm(char[][] matrix, int n, int m) {
        int[][] psm = new int[n][m];

        for(int j=0; j<m; j++) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                if(matrix[i][j] == '0') sum = 0;
                else sum += 1;
                psm[i][j] = sum;
            }
        }
        return psm;
    }

    // method to find largest rectangle in histogram
    private int findLargestRectangle(int[] histogram) {
        int n = histogram.length;

        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();
        int area = 0;

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && histogram[st.peek()] > histogram[i]) {
                int elementIdx = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                area = Math.max(area, histogram[elementIdx]*(nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int elementIdx = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            area = Math.max(area, histogram[elementIdx]*(nse-pse-1));
        }
        return area;
    }
}