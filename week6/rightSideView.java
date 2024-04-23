/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightView(root, 0);
        return result;
    }

    private void rightView(TreeNode currentNode, int currentLevel) {
        if (currentNode == null) {
            return;
        }

        if (currentLevel == result.size()) {
            result.add(currentNode.val);
        }

        rightView(currentNode.right, currentLevel + 1);
        rightView(currentNode.left, currentLevel + 1);

    }
}