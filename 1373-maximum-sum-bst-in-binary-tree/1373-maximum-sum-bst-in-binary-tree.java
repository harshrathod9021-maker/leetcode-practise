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

// Brute force

// class Solution {
//     int maxSum = 0;

//     public int maxSumBST(TreeNode root) {
//         inorder(root);

//         return maxSum;
//     }

//     void inorder(TreeNode root) {
//         if(root == null) return;

//         inorder(root.left);

//         if(validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
//             maxSum = Math.max(maxSum, calSum(root));
//         }

//         inorder(root.right);
//     }

//     boolean validateBST(TreeNode node, int lb, int ub) {
//         if(node == null) return true;

//         if(node.val <= lb || node.val >= ub) {
//             return false;
//         }

//         boolean leftAns = validateBST(node.left, lb, node.val);
//         boolean rightAns = validateBST(node.right, node.val, ub);

//         return leftAns && rightAns;
//     }

//     int calSum(TreeNode node) {
//         if(node == null) return 0;

//         int left = calSum(node.left);
//         int right = calSum(node.right);

//         return node.val + left + right;
//     }
// } 






// Optimal Solution

class NodeValue {
    public int minNode, maxNode, sum, maxSum;

    NodeValue(int minNode, int maxNode, int sum, int maxSum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
        this.maxSum = maxSum;
    }
}

class Solution {
    private NodeValue helper(TreeNode root) {
        if(root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // Current node is greater than max in left and smaller than min in right, it is a valid BST
        if(left.maxNode < root.val && right.minNode > root.val) {
            // It is BST
            int sum = left.sum + root.val + right.sum;

            return new NodeValue(Math.min(root.val, Math.min(left.minNode, right.minNode)), Math.max(root.val, Math.max(left.maxNode, right.maxNode)), sum, Math.max(0, Math.max(sum, Math.max(left.maxSum, right.maxSum))));
        }

        // Otherwise, return [-inf, inf] so that parent can't be a valid BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, Math.max(left.maxSum, right.maxSum));
    }

    public int maxSumBST(TreeNode root) {
        return helper(root).maxSum;
    }
} 