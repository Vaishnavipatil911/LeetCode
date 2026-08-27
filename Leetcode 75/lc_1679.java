import java.util.*;
public class lc_1679 {
    public int maxOperations(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;

    for (int x : nums) {
        int partner = k - x;

        if (map.getOrDefault(partner, 0) > 0) {
            count++;
            map.put(partner, map.get(partner) - 1);
        } else {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }

    return count;
}
}
