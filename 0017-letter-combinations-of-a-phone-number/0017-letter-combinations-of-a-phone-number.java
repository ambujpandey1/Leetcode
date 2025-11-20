class Solution {
    
    public static void helper(String digits,List<String> ans,int idx,String current,String map[]){
        if(idx==digits.length()){
            ans.add(current);
            return;
        }
    String s=map[digits.charAt(idx)-'0'];

    for(int i=0;i<s.length();i++){
        helper(digits,ans,idx+1,current+s.charAt(i),map);
    }
        
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        String map[] = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n=digits.length();
        if(n==0) return ans;
        helper(digits,ans,0,"",map);
        return ans;
    }
}