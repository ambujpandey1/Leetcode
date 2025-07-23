class Solution {
    boolean isSafe(char[][] board, char digit,int row, int col){
           // Horizonal
           for(int j=0;j<9;j++){
            if(board[row][j]==digit){
                return false;
            }
           }

           // Vertical
           for(int i=0;i<9;i++){
            if(board[i][col]==digit){
                return false;
            }
           }

           // Grid check
           int srow=(row/3)*3;
           int scol=(col/3)*3;

           for(int i=srow;i<=srow+2;i++){
            for(int j=scol;j<=scol+2;j++){
               if(board[i][j]==digit){
                return false;   
               } 
            }
           }
           return true;
    }

    boolean helper(char[][] board, int row, int col){
        if(row==9){
            return true;
        }
       int nextRow=row,nextCol=col+1;
       if(nextCol==9){
        nextRow=row+1;
        nextCol=0;
       }
        if(board[row][col]!='.'){
            return helper(board,nextRow,nextCol);
        }

        for(char digit='1';digit<='9';digit++){
            if(isSafe(board,digit,row,col)){
                board[row][col]=digit;
               if(helper(board,nextRow,nextCol)){
                return true;
               }
                board[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}