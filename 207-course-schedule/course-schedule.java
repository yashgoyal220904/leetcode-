import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

       
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, state, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return false; // cycle detected
        if (state[node] == 2) return true;  // already processed

        state[node] = 1; // mark visiting

        for (int nei : graph.get(node)) {
            if (!dfs(graph, state, nei)) {
                return false;
            }
        }

        state[node] = 2; // mark visited
        return true;
    }
}