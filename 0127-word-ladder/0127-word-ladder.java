class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        
        // set to store words from wordlist uniquely
        Set<String> set = new HashSet<>();
        for(String word: wordList) {
            set.add(word);
        }

        if(!set.contains(endWord)) return 0;

        // Queue to store word and steps - [word, steps]
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord, 1));

        set.remove(beginWord);

        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;

            if(word.equals(endWord)) return steps;

            char[] arr = word.toCharArray();
            for(int i=0; i<word.length(); i++) {
                char original = arr[i];
                for(char ch='a'; ch<='z'; ch++) {
                    if(ch == original) continue;
                    arr[i] = ch;
                    String next = new String(arr);
                    if(set.remove(next)) {
                        q.offer(new Pair(next, steps+1));
                    }
                }
                arr[i] = original;
            }
        }

        return 0;
    }
}

class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}