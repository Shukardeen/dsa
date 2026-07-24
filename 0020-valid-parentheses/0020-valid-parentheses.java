class Solution {
    public boolean isValid(String s) {
        // if(s.length() == 1) return false;
        // stack to store opening brackets
        Deque<Character> st = new ArrayDeque<>();

        // traverse the array
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else {
                if(st.isEmpty()) return false;
                char topChar = st.pop();
                if((topChar == '(' && ch == ')') || (topChar == '[' && ch == ']') || topChar == '{' && ch == '}') {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}