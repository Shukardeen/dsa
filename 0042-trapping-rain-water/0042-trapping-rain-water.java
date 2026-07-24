class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // varibable for left and right pointers
        int left = 0, right = n-1;

        // variable to track left and right greater buildings
        int leftMax = 0, rightMax = 0;

        // variable to store answer
        int ans = 0;

        // traverse
        while(left < right) {
            if(height[left] <= height[right]) {
                if(leftMax > height[left]) {
                    ans += leftMax - height[left];
                } else leftMax = height[left];
                left++;
            } else {
                if(rightMax > height[right]) {
                    ans += rightMax - height[right];
                } else rightMax = height[right];
                right--;
            }
        }
        return ans;
    }
}