import java.util.Stack;

public class lc_394 {
    class Solution {
    public String decodeString(String s) {
        int num=0;
        String currentString="";
        Stack<Integer>countStack=new Stack<>();
        Stack<String>stringStack=new Stack<>();

        for(char c:s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                num=num*10+(c-'0');
            }
            else if(Character.isLetter(c))
            {
                currentString+=c;
            }
            else if(c=='[')
            {
                countStack.push(num);
                stringStack.push(currentString);

                num=0;
                currentString="";
            }
            else if(c==']')
            {
                int repeat=countStack.pop();
                String previousString=stringStack.pop();

                StringBuilder temp=new StringBuilder(previousString);
                for(int i=0;i<repeat; i++)
                {
                temp.append(currentString);
                }
                currentString=temp.toString();
            }
        }
        return currentString;
        
    }
}
}
