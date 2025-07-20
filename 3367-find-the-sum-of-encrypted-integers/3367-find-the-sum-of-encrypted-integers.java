class Solution {
    private static int encrpted(int num){
        int maxDigit=0;
        int temp=num;
        int len=0;
        while(temp>0){
            maxDigit=Math.max(maxDigit,temp%10);
            temp/=10;
            len++;
        }
        int encr=0;
        for(int i=0;i<len;i++){
           encr=encr*10+maxDigit;
        }
       return encr;
    }
    public int sumOfEncryptedInt(int[] nums) {
       int sum=0;
       for(int i=0;i<nums.length;i++){
        sum+=encrpted(nums[i]);
       } 
       return sum;
    }
}