class Solution {
    public int getLucky(String s, int k) {
        String numericalString="";
        for(char ch:s.toCharArray()){
            numericalString+=ch-'a'+1;
        }

        while(k>0){
            int sum=0;
            for(char digit:numericalString.toCharArray()){
                sum+=digit-'0';
            }
            numericalString=Integer.toString(sum);
            k--;
        }

        return Integer.parseInt(numericalString);
    }
}