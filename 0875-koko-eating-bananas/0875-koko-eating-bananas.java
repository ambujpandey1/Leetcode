class Solution {
    int maximum(int[] arr){
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxi=Math.max(maxi,arr[i]);
        }

        return maxi;
    }
    int funReqt(int[] arr,int howely){
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+=Math.ceil((double)arr[i]/howely);
        }

        return total;
    }
    public int minEatingSpeed(int[] piles, int h) {
      int low=1;
      int high=maximum(piles);

      while(low<high){
        int mid=(low+high)/2;
        int reqTime=funReqt(piles,mid);
        if(reqTime<=h) high=mid;
        else low=mid+1;
      }  

      return low;
    }
}