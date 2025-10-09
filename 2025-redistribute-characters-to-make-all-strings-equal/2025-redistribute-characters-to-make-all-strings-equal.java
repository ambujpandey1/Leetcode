class Solution {
    public boolean makeEqual(String[] words) {
        if(words.length==1) return true;
        int fre[]=new int[26];
        for(String s:words){
            for(char c:s.toCharArray()){
                fre[c-'a']++;
            }
        }
      for(int c:fre){
        if(c%(words.length)!=0) return false;
      }
      return true;
    }
}