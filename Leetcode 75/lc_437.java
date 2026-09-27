import java.util.HashMap;

public class lc_437 {
    
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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer>map=new HashMap<>();
        map.put(0L,1);
        return dfs(root,0L,targetSum,map);

    }    
    private int dfs(TreeNode node,long CurrentSum, int targetSum, HashMap<Long,Integer>map)
    {
        if(node==null)
        {
            return 0;

        }
        CurrentSum+=node.val;
        int Count=map.getOrDefault(CurrentSum-targetSum,0);
        map.put(CurrentSum,map.getOrDefault(CurrentSum,0)+1);
        Count+=dfs(node.left,CurrentSum,targetSum,map);
        Count+=dfs(node.right,CurrentSum,targetSum,map);
        
        map.put(CurrentSum,map.get(CurrentSum)-1);
        return Count;
    }

}
}
