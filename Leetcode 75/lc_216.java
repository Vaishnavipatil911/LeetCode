import java.util.ArrayList;
import java.util.List;

public class lc_216 {
    class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>current=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        backtrack(1,k,n,current,result);
        return result;
        
    }

    public void backtrack(int start, int k, int target, List<Integer>current, List<List<Integer>>result)
    {
        if(k==0)
        {
            if(target==0)
            {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for(int i=start; i<=9-k+1; i++)
        {
            if(i>target)
            {
                break;
            }
            current.add(i);
            backtrack(i+1, k-1, target-i, current, result);
            current.remove(current.size()-1);
        }
    }
}
}
