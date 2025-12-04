/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void markParent(TreeNode root,  Map<TreeNode,TreeNode> parent_track,TreeNode target){

     Queue<TreeNode> queue=new LinkedList<TreeNode>();
     queue.offer(root);

     while(!queue.isEmpty()){
        TreeNode current=queue.poll();
        if(current.left!=null){
           parent_track.put(current.left,current);
           queue.offer(current.left); 
        }

        if(current.right!=null){
            parent_track.put(current.right,current);
           queue.offer(current.right); 
        }
     }


    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       Map<TreeNode,TreeNode> parent_track=new HashMap<>();
       markParent(root,parent_track,target); 

       Map<TreeNode,Boolean> visted=new HashMap<>();
       Queue<TreeNode> q=new LinkedList<>();
       q.offer(target);
       visted.put(target,true);

       int curr_level=0;
       while(!q.isEmpty()){
        int size=q.size();
        if(curr_level==k) break;
        curr_level++;
        for(int i=0;i<size;i++){
            TreeNode current=q.poll();
            if(current.left!=null && visted.get(current.left)==null){
                q.offer(current.left);
                visted.put(current.left,true);
            }

            if(current.right!=null && visted.get(current.right)==null){
                q.offer(current.right);
                visted.put(current.right,true);
            }
           
           if(parent_track.get(current)!=null && visted.get(parent_track.get(current))==null){
                q.offer(parent_track.get(current));
                visted.put(parent_track.get(current),true);
            }
        }
       }

       List<Integer> result=new ArrayList<>();
       while(!q.isEmpty()){
        TreeNode curr=q.poll();
        result.add(curr.val);
       }

       return result;
    }
}