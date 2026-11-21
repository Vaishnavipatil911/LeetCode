public class LC_714 {
    class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold=-prices[0];
        int cash=0;

        for(int i=1;i<prices.length;i++)
        {
            int prev_hold=hold;
            int prev_cash=cash;
            hold=Math.max(prev_hold,prev_cash-prices[i]);
            cash=Math.max(prev_cash,prev_hold+prices[i]-fee);

        }
        return cash;
    }
}
}
