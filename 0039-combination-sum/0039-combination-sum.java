class Solution {
   private void rec(int idx,int target ,int[] arr,List<List<Integer>> ans, List<Integer> ds ){
     if(idx==arr.length && target==0){
       ans.add(new ArrayList<>(ds));
         return ;
     }
   if(idx==arr.length) return;
     if(arr[idx]<=target){
            ds.add(arr[idx]);
            rec(idx,target-arr[idx],arr,ans,ds);
            ds.remove(ds.size()-1);
            }
            rec(idx+1,target,arr,ans,ds); 
   }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> a= new ArrayList<>();
       rec(0,target,candidates,ans,a);
       return ans;
    }
}