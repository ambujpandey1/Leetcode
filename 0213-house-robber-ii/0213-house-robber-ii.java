class Solution {

    public int houseRob(int[] nums) {
         int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];

     int prev2=nums[0];
    int prev=Math.max(nums[0],nums[1]);
    for(int i=2;i<n;i++){
        int pick=nums[i]+prev2;
        int notpick=prev;
        int curr=Math.max(pick,notpick);
        prev2=prev;
        prev=curr;

    }
    return  prev;
    }
    public int rob(int[] nums) {
         int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] temp1=new int[n];
        int [] temp2=new int[n];
        for(int i=0;i<n;i++){
           if(i!=0) temp1[i]=nums[i];
           if(i!=n-1) temp2[i] =nums[i];
        }

        return Math.max(houseRob(temp1),houseRob(temp2));
     
    }
}