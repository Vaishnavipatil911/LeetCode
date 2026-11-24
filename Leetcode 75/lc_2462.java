import java.util.PriorityQueue;

public class lc_2462 {
    class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int left=0;
        int right=costs.length-1;
        long totalCost=0;
        while(left<=right && left<candidates)
        {
            pq.offer(new int[]{costs[left],left});
            left++;
        }
        while(left <= right && right >= costs.length-candidates)
        {
            pq.offer(new int[]{costs[right],right});
            right--;

        }
        for(int i=0;i<k;i++)
        {
            int[] worker=pq.poll();
            totalCost+=worker[0];
            if(left<=right)
            {
                if(worker[1]<left)
                {
                    pq.offer(new int[]{costs[left],left});
                    left++;

                }
                else
                {
                    pq.offer(new int[]{costs[right],right});
                    right--;

                }
            }
        }
        return totalCost;

    }
}
}
