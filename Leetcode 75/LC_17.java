import java.util.ArrayList;
import java.util.List;

public class LC_17 {
    class Solution {
    String[]phone= {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
    public List<String> letterCombinations(String digits) {
    
        List<String> result=new ArrayList<>();
        if(digits.length()==0)
        {
            return result;
        }
        backtrack(0,digits,new StringBuilder(),result);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder current,List<String> result)
    {
        if(index==digits.length())
        {
            result.add(current.toString());
            return;
        }
        String letters=phone[digits.charAt(index)-'0'];

        for(int i=0;i<letters.length(); i++)
        {
            char ch=letters.charAt(i);
            current.append(ch);
            backtrack(index+1, digits, current, result);
            current.deleteCharAt(current.length()-1);

        }
    }
}
}
