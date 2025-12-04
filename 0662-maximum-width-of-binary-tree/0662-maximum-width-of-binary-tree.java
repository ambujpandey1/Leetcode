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
    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode n, int num){
            this.node=n;
            this.num=num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));


        while(!q.isEmpty()){
          int size=q.size();
          int min=q.peek().num;

          int first=0,last=0;
          for(int i=0;i<size;i++){
            int curridx=q.peek().num-min;
            TreeNode node=q.peek().node;
            q.poll();
            if(i==0 )first= curridx;
            if(i==size-1) last=curridx;

            if(node.left!=null) q.offer(new Pair(node.left,2*curridx+1));
            if(node.right!=null) q.offer(new Pair(node.right,2*curridx+2));
            

          }

          ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}