class Solution {
    static boolean dfs(char[][] mat,int r, int c, String word,int wordIndex){
        // Base cases
        // valid cases
        
        if(wordIndex==word.length()) return true;
        int rows=mat.length;
        int cols=mat[0].length;
        if(r<0 || c<0 || r>=rows ||c>=cols) return false;
        
        // invalid cases
        if(mat[r][c]==' '||mat[r][c]!=word.charAt(wordIndex)) return false;
        
        char ch=mat[r][c];
        // mark as visited
        mat[r][c]=' ';
        
        // Dfs call
        
        if(dfs(mat, r-1,  c,  word,wordIndex+1) || 
        dfs(mat, r,  c-1,  word,wordIndex+1) || 
        dfs(mat, r,  c+1,  word,wordIndex+1) || dfs(mat, r+1,  c,  word,wordIndex+1)){
            return true;
        }
        mat[r][c]=ch;
        return false;
    }
    public boolean exist(char[][] mat, String word) {
         int m=mat.length;
        int n=mat[0].length;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(word.charAt(0)==mat[r][c]){
                    boolean found=dfs(mat, r,  c,  word,0);
                    if(found) return true;
                }
            }
        }
        return false;
    }
}