class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int count=0;

      int sumApple=0;
      for(int a:apple){
        sumApple+=a;
      }

      for(int i=capacity.length-1 ;i>=0 ;i--){
        int c=capacity[i];
        if(sumApple <=0) break;
        sumApple-=c;
        count++;
        
      }
     return count;
    }
}