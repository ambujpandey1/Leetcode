class Solution {
    public int maxPower(String s) {
      int currentStrik=1;
      int maxStrick=1;
      for(int i=1;i<s.length();i++){
        char ch=s.charAt(i);
        char pc=s.charAt(i-1);
        if(ch==pc) currentStrik++;
        else currentStrik=1;
        maxStrick=Math.max(maxStrick,currentStrik);
      }  

      return maxStrick;
    }
}