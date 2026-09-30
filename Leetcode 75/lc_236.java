public class lc_236 {
    
 // Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);

    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q)
    {
        if(node==null)
        {
            return null;
        }
        if(node==p || node==q)
        {
            return node;
        }

        TreeNode leftResult=dfs(node.left,p,q);
        TreeNode rightResult=dfs(node.right,p,q);


        if(leftResult!=null && rightResult!=null)
        {
            return node;
        }
        if(leftResult!=null)
        {
            return leftResult;
        }
        if(rightResult!=null)
        {
            return rightResult;
        }
        return null;
}
}
}
