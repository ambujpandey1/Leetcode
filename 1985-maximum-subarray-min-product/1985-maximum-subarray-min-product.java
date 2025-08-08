class Solution {
    int[] prevSmallestElemt(int[] arr){
        int n= arr.length;
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[n];

        for(int i=0;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i]=-1;
            else ans[i]=st.peek();

            st.push(i);
        }

        return ans;
    }
    public int maxSumMinProduct(int[] nums) {
        int n=nums.length;
        long[] prefSum=new long[n+1];

        for(int i=0;i<n;i++){
           prefSum[i+1]=prefSum[i]+nums[i]; 
        }
        int []left=prevSmallestElemt(nums);

        Stack<Integer> st=new Stack<>();
        int right[]=new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()) right[i]=n;
            else right[i]=st.peek();

            st.push(i);
        }

        long max=0;
        for(int i=0;i<n;i++){
            int l=left[i];
            int r=right[i];
            long sum=prefSum[r]-prefSum[l+1];
            long prod=sum*nums[i];
            max=Math.max(max,prod);

        }
         return (int)(max % 1_000_000_007);
    }
}