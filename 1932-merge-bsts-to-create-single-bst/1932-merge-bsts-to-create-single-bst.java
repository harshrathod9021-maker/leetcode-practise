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
    Map<Integer, TreeNode> map = new HashMap<>();

    public TreeNode canMerge(List<TreeNode> trees) {
        for(TreeNode root : trees) {
            map.put(root.val, root);
        }

        // find the root of final BST
        Set<Integer> leaves = new HashSet<>();

        for(TreeNode root : trees) {
            if(root.left != null) {
                leaves.add(root.left.val);
            }

            if(root.right != null) {
                leaves.add(root.right.val);
            }
        }

        TreeNode root = null;

        for(TreeNode node : trees) {
            if(!leaves.contains(node.val)) {
                root = node;
                break;
            }
        }

        if(root == null) {
            return null;
        }

        // remove final root from map
        map.remove(root.val);

        // merged trees and validate BSTs
        if(!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return null;
        }

        if(!map.isEmpty()) {
            return null;
        }

        return root;
    }

    boolean dfs(TreeNode root, long lowerBound, long upperBound) {
        if(root == null) {
            return true;
        }

        // check the BST property
        if(root.val <= lowerBound || root.val >= upperBound) {
            return false;
        }

        // root is leaf node, check whether another tree has this value as its root
        if(root.left == null && root.right == null) {
            if(map.containsKey(root.val)) {
                TreeNode tree = map.get(root.val);

                // merged the tree
                root.left = tree.left;
                root.right = tree.right;

                map.remove(root.val);
            }
        }

        return dfs(root.left, lowerBound, root.val) && dfs(root.right, root.val, upperBound);
    }
} 