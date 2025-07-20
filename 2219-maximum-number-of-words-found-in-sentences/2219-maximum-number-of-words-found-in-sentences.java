class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxlen=0;
        for(String sentance:sentences){
            String[] words=sentance.split(" ");
            int len=words.length;
            maxlen=Math.max(len,maxlen);
        }

        return maxlen;
    }
}