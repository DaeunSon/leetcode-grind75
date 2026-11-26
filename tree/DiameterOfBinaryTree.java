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

    int len = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 1. 어떤 유형인지와 그 단서 - 이진트리, 최대 경로 길이 구하기. left root right 순서로 조회한다.(중위)
        // 2. 쓸 틀과 이 문제에서 바뀌는 부분 - DFS, 재귀함수, 중위순회, 바뀌는 부분은 길이 length를 구하는것
        // 3. 예상 시간복잡도 - O(n)
        getMaxLength(root);
        return len;
    }

    public int getMaxLength(TreeNode root) {
        //termination
        if (root == null) return 0; //맨 끝에 도달했을때

        int left_len = getMaxLength(root.left);
        int right_len = getMaxLength(root.right);
        len = Math.max(len, left_len + right_len);

        return Math.max(left_len+1, right_len+1);

    }
}
