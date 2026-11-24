import java.util.Stack;

public class lc_901 {
    class StockSpanner {
    Stack<int[]>stack;
    public StockSpanner() {
        stack=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price)
        {
            int[] prev=stack.pop();
            span+=prev[1];
        }
        stack.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
