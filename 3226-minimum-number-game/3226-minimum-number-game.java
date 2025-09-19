class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] res=new int[nums.length];
      
        for(int i=0;i<nums.length;i+=2){
            int t1=nums[i];
            int t2=nums[i+1];
            res[i]=t2;
            res[i+1]=t1;
        }

       
        return res;
    }
}