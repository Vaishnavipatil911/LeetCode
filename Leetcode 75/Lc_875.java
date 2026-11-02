class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;

        for(int pile: piles)
        {
           right = Math.max(right, pile);
        }
        while(left<=right)
        {
            long totalHours=0;
            int mid=left+(right-left)/2;

            for(int pile:piles)
            {
                totalHours+=(pile + (long) mid - 1) / mid;
            }

            if(totalHours<=h)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }
}