class Solution {

    boolean checkTrailingZero(int num){
        String n=Integer.toBinaryString(num);
        if(n.charAt(n.length()-1)=='0') return true;
        return false;
    }
    public boolean hasTrailingZeros(int[] nums) {
      for(int i=0;i<nums.length;i++){
        for(int j=i;j<nums.length;j++){
            int num=(nums[i] | nums[j]);
            if(i!=j && checkTrailingZero(num)){
                return true;
            }
        }
      }  
      return false;
    }
}