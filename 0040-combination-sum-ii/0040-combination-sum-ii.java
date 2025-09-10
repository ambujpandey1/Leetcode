class Solution {
    void helper(int idx,List<List<Integer>> ans,int[] arr,int target,List<Integer> list){
       if( target==0){
        ans.add(new ArrayList<>(list));
       return;
       }
       for(int i=idx;i<arr.length;i++){
        if(i>idx && arr[i]==arr[i-1]) continue;
        if(arr[i]>target) break;
        list.add(arr[i]);
        helper(i+1,ans,arr,target-arr[i],list);
        list.remove(list.size()-1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,ans,candidates,target,list);

        return ans;
    }
}