class Solution {
   boolean  isPossible(int[] nums, int d, int t){
    int sum=0;

    for(int i=0;i<nums.length;i++){
       sum += (int) Math.ceil((double) nums[i] / d);

    }
    if(sum<=t) return true;

    return false;
   }
    public int smallestDivisor1(int[] nums, int threshold) {
       int max=Integer.MIN_VALUE;
         
        for(int n:nums){
            max=Math.max(max,n);
        } 
       for(int i=1;i<=max;i++){
            if(isPossible(nums,i,threshold)==true) return i;

       } 

       return -1;
    }
     public int smallestDivisor(int[] nums, int threshold) {
   // return  smallestDivisor(nums,threshold); // brute force


       int max=Integer.MIN_VALUE;
         
        for(int n:nums){
            max=Math.max(max,n);
        } 
      Arrays.sort(nums);
      int low=1;
      int high=max;
      int ans=-1;
      while(low<=high){
         int mid=(low+high)/2;
          if(isPossible(nums,mid,threshold)==true) {
            ans=mid;
            high=mid-1;
          }
          else low=mid+1; 
      }
      return ans;
    }
}