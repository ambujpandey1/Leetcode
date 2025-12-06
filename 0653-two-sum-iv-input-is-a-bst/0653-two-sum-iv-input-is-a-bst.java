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
    void inorder(TreeNode root,List<Integer> in){
        if(root==null) return;

        inorder(root.left,in);
        in.add(root.val);
        inorder(root.right,in);
    }

    boolean twoSum( int k,List<Integer> in){
        int left=0;
        int right=in.size()-1;

        while(left<right){

            int sum=in.get(left)+in.get(right);
            if(sum==k) return true;

            if(sum<k) left++;
            if(sum>k) right--;
        }
        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> in=new ArrayList<>();
        inorder(root,in);

        return twoSum(k,in);
    }
}