class Solution {
    public int pivotInteger(int n) {
       int totalSum=n*(n+1)/2;
       int leftsum=0;
      
       for(int x=1;x<=n;x++){
        leftsum+=x;
        if(leftsum==totalSum-leftsum+x) return x;
       }
         
        return -1;
    }
}