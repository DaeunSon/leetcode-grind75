/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;              // 종료 조건: 빈 트리의 깊이는 0
        int left = maxDepth(root.left);          // 왼쪽 트리에 맡기기
        int right = maxDepth(root.right);        // 오른쪽 트리에 맡기기
        return Math.max(left, right) + 1;        // 합치기: 더 깊은 쪽 + 나 자신
    }
}
