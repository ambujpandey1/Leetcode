class Solution {
    private void findSunsetSum(int idx,int[] nums,List<List<Integer>> ansList,ArrayList<Integer> ds){
        ansList.add(new ArrayList<>(ds));

        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findSunsetSum(i+1,nums,ansList,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList=new ArrayList<>();
        findSunsetSum(0,nums,ansList,new ArrayList<>());
        return ansList;

    }
}