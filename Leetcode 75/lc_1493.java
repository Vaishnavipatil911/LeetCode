public class lc_1493 {
    class Solution {
    public int longestSubarray(int[] nums) {
        
        int left=0;
        int zeroCount=0;
        int maxLength=0;
        for(int right=0;right<nums.length; right++)
        {
            if(nums[right]==0)
            {
                zeroCount++;
            }
            while(zeroCount>1)
            {
                if(nums[left]==0)
                {
                    zeroCount--;
                }
                left++;
            }
            int currentLength=right-left+1;
            maxLength=Math.max(maxLength,currentLength-1);
        }
        return maxLength;
    }
}
}
