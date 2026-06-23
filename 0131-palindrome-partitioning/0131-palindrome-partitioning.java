class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        // partition storing array
        List<String> p = new ArrayList<>();
        // recursive function call
        fn(0, s, p, ans);
        return ans;
    }

    // recursive function
    private void fn(int index, String s, List<String> partition, List<List<String>> ans) {
        // base case
        if(index == s.length()) {
            ans.add(new ArrayList<>(partition));
            return;
        }
        // loop to detect partitions
        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                // if palindrome, add to the partition list
                partition.add(s.substring(index, i+1));
                // recursive call
                fn(i+1, s, partition, ans);
                // remove the last added partition after returning from recursion
                partition.removeLast();
            }
        }
    }

    // function to verify if the current substring is a palindrome or not
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}