import java.util.Stack;

public class lc_2390 {
    class Solution {
    public String removeStars(String s) {
    Stack<Character>stack=new Stack<>();
    char[] charArray=s.toCharArray();
    for(int i=0; i<charArray.length; i++)
    {
        if(charArray[i]!='*')
        {
            stack.push(charArray[i]);

        }
        else
        {
            stack.pop();
        }
        }
        StringBuilder result=new StringBuilder();
        for(char c: stack)
        {
            result.append(c);
        }
    
    return result.toString();

    }
}
}
