class Solution {
    // bruite Force
    public static int[] maxSli(int[] nums, int k){
        int n=nums.length;
        int []ans=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int max=0;
            for(int j=i;j<i+k;j++){
                max=Math.max(max,nums[j]);
            }
            ans[i]=max;
        }

        return ans;
    }

    // Optimal Approach dequeue approach

    int[] maxSliOptimal(int[] nums,int k){
        int n=nums.length;
        int []ans=new int[n-k+1];
        int r=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){ 
          
          if(!dq.isEmpty() && dq.peek()==i-k) dq.poll();

          while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) dq.pollLast();

          dq.offer(i);
          if(i>=k-1){
            ans[r++]=nums[dq.peek()];
          }
         }

         return ans;

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
    //   return maxSli(nums,k);  // Brute Force

      return maxSliOptimal(nums,k);  // Optimal
    }
}