import java.util.LinkedList;
import java.util.Queue;

public class lc_994 {
    class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>queue=new LinkedList<>();
        int fresh=0;

        for(int r=0;r<grid.length;r++)
        {
            for(int c=0;c<grid[0].length;c++)
            {
                if(grid[r][c]==2)
                {
                    queue.offer(new int[]{r,c});
                }
                else if(grid[r][c]==1)
                {
                    fresh++;
                }

            }
        }


        int[][] directions=
        {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        int minutes=0;

        while(!queue.isEmpty() && fresh > 0)
        {
            boolean rottenThisMinute=false;
            int size=queue.size();

            for(int i=0;i<size;i++)
            {
            int[] current=queue.poll();
            int r=current[0];
            int c=current[1];

            

            for(int[]dir:directions)
            {
                int nr=r+dir[0];
                int nc=c+dir[1];
            

            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1)
            {
                grid[nr][nc]=2;
                queue.offer(new int[]{nr,nc});
                fresh--;
                rottenThisMinute=true;
            }
            }
            }

            if(rottenThisMinute)
            {
                minutes++;
            }

        }
        if(fresh==0)
        {
            return minutes;
        }
        else
        {
            return -1;
        }

        
    }
}
}
