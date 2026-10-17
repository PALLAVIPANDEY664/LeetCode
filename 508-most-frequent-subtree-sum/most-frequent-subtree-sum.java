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
import java.util.*;

class Solution {
    private int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        postOrder(root, countMap);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int postOrder(TreeNode node, Map<Integer, Integer> countMap) {
        if (node == null) return 0;

        int leftSum = postOrder(node.left, countMap);
        int rightSum = postOrder(node.right, countMap);

        int totalSum = node.val + leftSum + rightSum;
        int count = countMap.getOrDefault(totalSum, 0) + 1;
        countMap.put(totalSum, count);

        maxCount = Math.max(maxCount, count);
        return totalSum;
    }
}