import java.util.*;
class Solution {
    public int minReorder(int n, int[][] connections) {
    List<List<int[]>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }

    for (int[] connection : connections) {
        int a = connection[0];
        int b = connection[1];

        graph.get(a).add(new int[]{b, 1});
        graph.get(b).add(new int[]{a, 0});
    }

    boolean[] visited = new boolean[n];

    return dfs(0, graph, visited);
}

int dfs(int city, List<List<int[]>> graph, boolean[] visited) {
    visited[city] = true;
    int changes = 0;

    for (int[] edge : graph.get(city)) {
        int neighbor = edge[0];
        int direction = edge[1];

        if (!visited[neighbor]) {
            changes += direction;
            changes += dfs(neighbor, graph, visited);
        }
    }

    return changes;
}
}
    
