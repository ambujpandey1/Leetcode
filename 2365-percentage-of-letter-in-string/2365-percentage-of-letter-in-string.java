class Solution {
    public int percentageLetter(String s, char letter) {
        int l=0;
       for(char c:s.toCharArray()){
        if(c==letter) l++;
       } 
       int m=s.length();
       int percentage=(l*100)/m;
       return percentage;
    }
}