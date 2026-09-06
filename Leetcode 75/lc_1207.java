import java.util.HashMap;
import java.util.HashSet;

public class lc_1207 {
    class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int x: arr)
        {
            map.put(x,map.getOrDefault(x,0) +1);

        }
        set.addAll(map.values());
        
        return map.values().size()==set.size();
    }
}
}
