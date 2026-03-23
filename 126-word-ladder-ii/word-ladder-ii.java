import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!wordSet.contains(endWord)) return result;

        // BFS: build parent map (child -> set of parents)
        Map<String, Set<String>> parents = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {
            wordSet.removeAll(currentLevel);   // prune visited words
            Set<String> nextLevel = new HashSet<>();

            for (String word : currentLevel) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            nextLevel.add(newWord);
                            parents.computeIfAbsent(newWord, k -> new HashSet<>()).add(word);
                            if (newWord.equals(endWord)) found = true;
                        }
                    }
                    chars[i] = original;   // restore
                }
            }
            currentLevel = nextLevel;
        }

        if (!found) return result;

        // DFS: backtrack from endWord to beginWord using parent map
        LinkedList<String> path = new LinkedList<>();
        path.addFirst(endWord);
        dfs(endWord, beginWord, parents, path, result);

        return result;
    }

    private void dfs(String word, String beginWord,
                     Map<String, Set<String>> parents,
                     LinkedList<String> path,
                     List<List<String>> result) {
        if (word.equals(beginWord)) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (!parents.containsKey(word)) return;

        for (String parent : parents.get(word)) {
            path.addFirst(parent);
            dfs(parent, beginWord, parents, path, result);
            path.removeFirst();   // backtrack
        }
    }
}