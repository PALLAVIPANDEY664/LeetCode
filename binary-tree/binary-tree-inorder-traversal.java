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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 1. Create the list to store the answer
        List<Integer> result = new ArrayList<>();
        
        // 2. Call a helper function to fill the list
        traverse(root, result);
        
        // 3. Return the filled list
        return result;
    }

    // Helper function to perform the recursion
    private void traverse(TreeNode node, List<Integer> list) {
        // Base case: if node is null, stop
        if (node == null) {
            return;
        }

        // Step 1: Go Left
        traverse(node.left, list);

        // Step 2: Visit Root (Add value to list)
        list.add(node.val);

        // Step 3: Go Right
        traverse(node.right, list);
    }
}