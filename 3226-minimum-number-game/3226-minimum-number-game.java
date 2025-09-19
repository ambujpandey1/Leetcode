class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] res=new int[nums.length];
      List<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            int t1=nums[i];
            int t2=nums[i+1];
            arr.add(t2);
            arr.add(t1);
        }

        for(int i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}