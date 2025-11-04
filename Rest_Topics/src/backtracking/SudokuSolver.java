package backtracking;



/**
 * Problem: 37. Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 * A sudoku solution must satisfy all the following rules:

 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */


//Test case
    /*
5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9
     */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    private boolean helper(char[][] board, int row, int col){
        for(int j=0;j<9;j++){
            for(int k=0;k<9;k++){
                if(board[j][k]!='.') {
                    continue;
                }
                for(int i=1;i<=9;i++){
                    board[j][k]=(""+i).charAt(0);
                    boolean isvalid=isValid(board, j, k);
                    if(isvalid){//valid, so move to the next by saving ans
                        if(helper(board, j, k+1))return true;
                    }
                    board[j][k]='.';

                }
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char [][]board, int row, int col){
        int currentEle=board[row][col];
        for(int i=0;i<9;i++){
            if(i!=col && board[row][i]==currentEle)return false;
            if(i!=row && board[i][col]==currentEle)return false;
        }
        int giantRow=row/3;
        int giantCol=col/3;
        for(int i=giantRow*3;i<giantRow*3+3;i++){
            for(int j=giantCol*3;j<giantCol*3+3;j++){
                if(i==row && j==col)continue;
                if(board[i][j]==currentEle)return false;
            }
        }
        return true;
    }
}
