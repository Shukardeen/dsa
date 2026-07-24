class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        for(int num: asteroids) {
            boolean isAlive = true;
            while(isAlive && !st.isEmpty() && st.peek() > 0 && num < 0) {
                int top = st.peek();
                if(top < -num) st.pop();
                else if(top == -num) {
                    st.pop();
                    isAlive = false;
                } else isAlive = false;
            }
            if(isAlive) st.push(num);
        }

        if(st.isEmpty()) return new int[0];
        if(st.size() == 1) return new int[]{st.pop()};

        // temp stack
        Deque<Integer> temp = new ArrayDeque<>();
        while(!st.isEmpty()) {
            temp.push(st.pop());
        }

        // answer array - the final state
        int[] ans = new int[temp.size()];
        int i = 0;
        while(!temp.isEmpty()) {
            ans[i++] = temp.pop();
        }
        return ans;
    }
}