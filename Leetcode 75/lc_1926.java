import java.util.LinkedList;
import java.util.Queue;

public class lc_1926 {
    class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();

        int row = entrance[0];
        int col = entrance[1];

        queue.offer(new int[]{row, col});
        maze[row][col] = '+';

        int steps = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                row = current[0];
                col = current[1];

                int[][] directions = {
                    {-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1}
                };

                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < maze.length &&
                        newCol >= 0 && newCol < maze[0].length &&
                        maze[newRow][newCol] == '.') {

                        if (newRow == 0 ||
                            newRow == maze.length - 1 ||
                            newCol == 0 ||
                            newCol == maze[0].length - 1) {

                            return steps + 1;
                        }

                        maze[newRow][newCol] = '+';
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
   

}
