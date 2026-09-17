package stack;
import java.util.*;
public class lc_150 {
     
    class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> stack=new Stack<>();
        for(int i=0; i<tokens.length; i++)
        {
            String token=tokens[i];

            if(token.equals("+"))
            {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b+a);

            }
            else if(token.equals("-"))
            {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b-a);
                
            }
            else if(token.equals("*"))
            {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b*a);
                
            }
            else if(token.equals("/"))
            {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b/a);
                
            }
            else
            {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
        
    }
}
}
