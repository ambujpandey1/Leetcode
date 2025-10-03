class Solution {
    class Pair{
        String first;
        int steps;
        Pair(String f,int s){
            this.first=f;
            this.steps=s;
        }
    }

    private int wordLengthLadder(String beginWord, String endWord, List<String> wordList){
      Queue<Pair> q=new LinkedList<>();
      q.add(new Pair(beginWord,1));
      Set<String> set=new HashSet<>();

      for(int i=0;i<wordList.size();i++){
        set.add(wordList.get(i));
      }
      set.remove(beginWord);

      while(!q.isEmpty()){
        String word=q.peek().first;
        int step=q.peek().steps;
        q.remove();
        
        if(word.equals(endWord)) return step;
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char replaceCharArray[]=word.toCharArray();
                replaceCharArray[i]=ch;
                String replaceWord=new String(replaceCharArray);
                
                if(set.contains(replaceWord)){
                    set.remove(replaceWord);
                    q.add(new Pair(replaceWord,step+1));
                }
            }
        }
      }
      return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       return wordLengthLadder(beginWord,endWord,wordList) ;
    }
}