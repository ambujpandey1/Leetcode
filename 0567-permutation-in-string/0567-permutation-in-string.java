class Solution {
    boolean isSameFre(int[] fre1,int[] fre2){
        for(int i=0;i<26;i++){
            if(fre1[i]!=fre2[i]) return false;
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] fre=new int[26];

        for(int i=0;i<s1.length();i++){
            fre[s1.charAt(i)-'a']++;
        }

        int windowlength=s1.length();

        for(int i=0;i<s2.length();i++){
            int windoidx=0, idx=i;
            int[] windFre=new int[26];
            while(windoidx<windowlength && idx<s2.length()){
               windFre[s2.charAt(idx)-'a']++;
               windoidx++;
               idx++;
            }

            if(isSameFre(fre,windFre)) return true;
        }

        return false;
    }
}