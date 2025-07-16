class Solution {
    public boolean isIsomorphic(String s, String t) {
        return helper(s).equals(helper(t));
    }

    private static String helper(String str){
        StringBuilder sb=new StringBuilder();
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,i);
            }
            sb.append(map.get(ch));
            sb.append("-");
        }
        return sb.toString();
    }
}