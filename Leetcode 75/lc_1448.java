public class lc_1448 {
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
    public int goodNodes(TreeNode root) {
        int val=dfs(root, Integer.MIN_VALUE);
        return val;
    }
    public int dfs(TreeNode node, int maxFar)
    {
        if(node==null)
        {
            return 0;
        }
        int currentCount=0;

        if(node.val>=maxFar)
        {
            currentCount++;
        }
        int newMax=Math.max(maxFar,node.val);
        int leftCount=dfs(node.left, newMax);
        int rightCount=dfs(node.right, newMax);

        return currentCount+leftCount+rightCount;
    }
}
}
