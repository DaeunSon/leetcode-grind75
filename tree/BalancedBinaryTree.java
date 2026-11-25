/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        //DFS, left right root -> postorder

        int left_height = height(root.left);
        int right_height = height(root.right);
        if (left_height == -1 || right_height == -1) return -1;

        if (Math.abs(left_height - right_height) > 1) return -1;
        else return Math.max(left_height+1, right_height+1);
    }
}
