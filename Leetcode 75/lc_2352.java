import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc_2352 {
    class Solution {
    public int equalPairs(int[][] grid) {
        int count=0;
        HashMap<List<Integer>,Integer>map=new HashMap<>();

        for(int i=0; i<grid.length; i++)
        {
            List<Integer>row=new ArrayList<>();
            for(int val: grid[i])
            {
                row.add(val);
                map.put(row, map.getOrDefault(row,0)+1);
            }

        }
        for(int j=0;j<grid.length;j++)
        {
            List<Integer>col=new ArrayList<>();

            for(int i=0;i<grid.length;i++)
            {
                col.add(grid[i][j]);
            }
            if(map.containsKey(col))
            {
                count+=map.get(col);
            }
        }
        return count;
    }
}
}
