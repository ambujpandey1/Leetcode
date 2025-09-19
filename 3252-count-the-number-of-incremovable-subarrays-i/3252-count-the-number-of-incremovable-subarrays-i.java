class Solution {
    boolean isIncresing(int[] nums,int start, int end){
        int prev=0;

        for(int i=0;i<nums.length;i++){
            if(i<=end && i>=start) continue;
            if(nums[i]<=prev) return false;
            prev=nums[i];
        }
        return true;
    }
    public int incremovableSubarrayCount(int[] nums) {
        int count=0;

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(isIncresing(nums,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
}