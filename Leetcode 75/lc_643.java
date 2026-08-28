public class lc_643 {
    class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0; i<k; i++)
        {
            sum=sum+nums[i];
        }   
        int maxSum=sum;
        for(int i=k; i<nums.length; i++)
        {
            int outgoing=nums[i-k];
            int incoming=nums[i];
            sum=sum-outgoing+incoming;
            maxSum=Math.max(sum,maxSum);
        }     
        return (double)maxSum/k;
    }
}
}
