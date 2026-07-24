class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // array to store next greater elements of nums1 elements
        int[] nge1 = new int[n1];
        // array to store next greater elements of nums2 elements
        int[] nge2 = new int[n2];

        // stack to store greater elements
        Deque<Integer> st = new ArrayDeque<>();

        // find next greater elements for nums2 elements using monotonic stack (decreasing order)
        for(int i=(n2-1); i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            nge2[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        // get the next greater elements of nums1 from nge2
        for(int i=0; i<n1; i++) {
            int j = 0;
            while(j<n2) {
                if(nums2[j] == nums1[i]) {
                    nge1[i] = nge2[j];
                    break;
                }
                j++;
            }
        }
        return nge1;
    }
}