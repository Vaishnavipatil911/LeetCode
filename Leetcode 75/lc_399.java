import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc_399 {
    class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
        String a = equations.get(i).get(0);
        String b = equations.get(i).get(1);
        double weight = values[i];
        graph.putIfAbsent(a, new HashMap<>());
        graph.putIfAbsent(b, new HashMap<>());
        graph.get(a).put(b, weight);
        graph.get(b).put(a, 1.0 / weight);
    }
    double[] answer = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
        String source = queries.get(i).get(0);
        String destination = queries.get(i).get(1);
        if (!graph.containsKey(source) ||
            !graph.containsKey(destination)) {
            answer[i] = -1.0;
            continue;
        }
        Set<String> visited = new HashSet<>();

        answer[i] = dfs(
            source,
            destination,
            1.0,
            graph,
            visited
        );
    }

    return answer;
}
private double dfs(
    String current,
    String destination,
    double product,
    Map<String, Map<String, Double>> graph,
    Set<String> visited
) {
    if (current.equals(destination)) {
        return product;
    }

    visited.add(current);

    for (Map.Entry<String, Double> entry :
         graph.get(current).entrySet()) {

        String neighbor = entry.getKey();
        double weight = entry.getValue();

        if (!visited.contains(neighbor)) {
            double result = dfs(
                neighbor,
                destination,
                product * weight,
                graph,
                visited
            );

            if (result != -1.0) {
                return result;
            }
        }
    }

    return -1.0;
}

        
    }

}
