class Solution {
    static boolean isPossible(int[] bloomDay,int day, int m, int k){
        int count=0;
        int bought=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                count++;
                
            }else {
                bought+=count/k;
                count=0;
            }
        }
         bought+=count/k;
        return bought>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long req=(long) m*k;
        int n=bloomDay.length;
          if(req>n) return -1;
        int minDay=Integer.MAX_VALUE;
        int maxDay=Integer.MIN_VALUE;

        for(int bloom:bloomDay){
            minDay=Math.min(bloom,minDay);
            maxDay=Math.max(bloom,maxDay);
        }
        int ans=-1;
        int low=minDay;
        int high=maxDay;

        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
}