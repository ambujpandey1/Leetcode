class Solution {
    public int prefixCount(String[] words, String pref) {
       int l=pref.length();
       int let=0;
       for(String str:words){
       if(str.length()>=l){
        String s=str.substring(0,l);
        if(s.equals(pref)) let++;
       }
       } 
       return let;
    }
}