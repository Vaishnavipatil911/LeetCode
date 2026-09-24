import java.util.ArrayList;
import java.util.List;

public class lc_372 {

 // Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>leaves1=new ArrayList<>();
        List<Integer>leaves2=new ArrayList<>();
        int i=0;
        int j=0;

        dfs(root1,leaves1);
        dfs(root2,leaves2);

        if(leaves1.size() != leaves2.size())
        {
            return false;
        }

        while(i<leaves1.size() && j<leaves2.size())
        {
            if(!leaves1.get(i).equals(leaves2.get(j)))
            {
                return false;
            }
            i++;
            j++;

        }
        return true;
        
    }
    void dfs(TreeNode node, List<Integer>leaves)
    {
        if(node==null)
        {
            return ;

        }

        if(node.left==null && node.right==null)
        {
            leaves.add(node.val);

        }
        else
        {
            dfs(node.left, leaves);
            dfs(node.right, leaves);
        }
    }
}
}
