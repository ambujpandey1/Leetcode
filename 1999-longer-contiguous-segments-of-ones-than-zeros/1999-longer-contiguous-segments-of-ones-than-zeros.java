class Solution {
    public boolean checkZeroOnes(String s) {
        int maxZeros=0,maxOnes=0,ones=0,zeros=0;
        for(char ch:s.toCharArray()){
            if(ch=='1') {
                ones++;
                zeros=0;
            }else{
                zeros++;
                ones=0;
            }
            maxZeros=Math.max(maxZeros,zeros);
            maxOnes=Math.max(maxOnes,ones);
           
        }

        if(maxOnes>maxZeros) return true;
        return false;
    }
}