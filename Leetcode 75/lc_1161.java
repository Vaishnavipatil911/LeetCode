import java.util.LinkedList;
import java.util.Queue;

public class lc_1161 {
    
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
    public int maxLevelSum(TreeNode root) {
    if (root == null) {
        return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int level = 1;
    int maxSum = Integer.MIN_VALUE;
    int answerLevel = 1;

    while (!queue.isEmpty()) {

        int count = 0;
        int currentLevelSize = queue.size();
        int currentLevelSum = 0;

        
        while (count < currentLevelSize) {

            TreeNode current = queue.poll();

            currentLevelSum += current.val;

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }

            count++;
        }

        
        if (currentLevelSum > maxSum) {
            maxSum = currentLevelSum;
            answerLevel = level;
        }

        level++;
    }

    return answerLevel;
}
    }

}
