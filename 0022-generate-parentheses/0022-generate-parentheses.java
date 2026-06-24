class Solution {
    public List<String> generateParenthesis(int n) {
        // number of open and close parenthesis initially
        int open = 0;
        int close = 0;
        // answer list
        List<String> ans = new ArrayList<>();
        // string to store single pair
        StringBuilder pair = new StringBuilder();
        // recursive function call
        generate(n, open, close, pair, ans);
        return ans;
    }

    private void generate(int n, int open, int close, StringBuilder pair, List<String> ans) {
        if(open == n && close == open) {
            ans.add(pair.toString());
            return;
        }
        if(open < n) {
            pair.append("(");
            generate(n, open+1, close, pair, ans);
            pair.deleteCharAt(pair.length() - 1);
        }
        if(close < open) {
            pair.append(")");
            generate(n, open, close+1, pair, ans);
            pair.deleteCharAt(pair.length() - 1);
        }
    }
}