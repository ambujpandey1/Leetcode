class Solution {
    int getSetbit(int n){

        int count=0;
        while(n>0){
            count+=n & 1;
            n>>=1;
        }
        return count;
    }
  
    public boolean canSortArray(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1] && (getSetbit(nums[j])==getSetbit(nums[j+1]))){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }

        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]) return false;
        }
        return true;
    }
}