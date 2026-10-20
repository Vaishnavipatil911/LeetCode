import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        return bfs(source,destination,graph,visited);
        
        
    }
    boolean bfs(int node, int destination,
            List<List<Integer>> graph, boolean[] visited) {

    Queue<Integer>queue=new LinkedList<>();
    queue.offer(node);
    visited[node]=true;

    while(!queue.isEmpty())
    {
    int current=queue.poll();

    if (current == destination) {
        return true;
    }

    for(int neighbor:graph.get(current))
    {
        if(!visited[neighbor])
        {
            visited[neighbor]=true;
            queue.offer(neighbor);
        }
    }


    }
    return false;
}
    
}