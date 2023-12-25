class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char c = board[i][j];
                if( c >='0' && c <= '9' && !isValid(board, i, j)) return false; 
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int r, int c){
        for(int i=0; i<9; i++){
            if(r!=i && board[i][c] == board[r][c]) return false; // checking column
            if(c!=i && board[r][i] == board[r][c]) return false; // checking row
        }
        
        //Checking for 3x3 box
        int rowStart = 3 * (r/3); 
        int colStart = 3 * (c/3);

        for(int i=rowStart; i<rowStart + 3; i++){
            for( int j = colStart; j<colStart + 3; j++){
                if(i!=r && j!=c && board[i][j] == board[r][c]) return false; 
            }
        }

        return true;
    }
}
