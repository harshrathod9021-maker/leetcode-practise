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

class Pair{
    TreeNode root ;
    int ind ;
    Pair(TreeNode root, int ind){
        this.root = root ;
        this.ind = ind ;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0 ;
        }

        Queue<Pair> que = new LinkedList<Pair>();
        que.offer(new Pair(root,0));
        int ans = 1 ;
        while(!que.isEmpty()){
            int n = que.size();
            int min = Integer.MAX_VALUE ; 
            int max = Integer.MIN_VALUE ;
            for(int i = 0 ; i < n ; i++){
                Pair p = que.poll();
                TreeNode curr = p.root ;
                int ind = p.ind ;
                min = Math.min(min,ind);
                max = Math.max(max,ind);

                if(curr.left != null){
                    que.offer(new Pair(curr.left, ( (2 * (ind - min)) + 1)) );
                }

                if(curr.right != null){
                    que.offer(new Pair(curr.right, ( (2 * (ind - min)) + 2)) );
                }
            }
            ans = Math.max(ans, (max - min + 1));
        }

        return ans ;
    }
}