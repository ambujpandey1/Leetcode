class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a=0,b=0;
        
        for(int i=0;i<nums.length;i++){
            a=nums[i];
            for(int j=i+1;j<nums.length;j++){
                b=nums[j];
                int c=a+b;
                if(c==target) return new int[]{i,j};

            }
        }
        return new int[]{-1,-1};
    }
}