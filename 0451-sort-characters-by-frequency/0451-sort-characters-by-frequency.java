class Solution {
    public String frequencySort(String s) {
        if(s.length() == 1) return s;
        // map to store frequency of characters
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        // buckets to store characters at their frequency index
        List<List<Character>> buckets = new ArrayList<>();
        for(int i=0; i<=s.length(); i++) {
            buckets.add(new ArrayList<>());
        }

        // put characters from map to buckets
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        // build answer from buckets
        StringBuilder ans = new StringBuilder();
        for(int i=buckets.size()-1; i>=0; i--) {
            List<Character> bucket = buckets.get(i);
            if(bucket.isEmpty()) continue;
            else {
                for(char ch: bucket) {
                    for(int j=0; j<i; j++) {
                        ans.append(ch);
                    }
                }
            }
        }
        return ans.toString();
    }
}