class Solution {
    static void f(int sum,int last,List<List<Integer>> ans,List<Integer> nums,int k ){
       if(sum==0 && nums.size()==k){
        ans.add(new ArrayList<>(nums));
        return;
       }
       if(sum<=0 && nums.size()>k) return;
       for(int i=last; i<=9;i++){
        if(i<=sum){
         nums.add(i);
         f(sum-i,i+1,ans,nums,k);
         nums.remove(nums.size()-1);
        }
        else break;
       }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> nums=new ArrayList<>();
        f(n,1,ans,nums,k);
        return ans;
    }
}