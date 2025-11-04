package backtracking;


/**
 * Problem: 2596. Check Knight Tour Configuration.

 * There is a knight on an n x n chessboard. In a valid configuration,
 * the knight starts at the top-left cell of the board and visits every cell on the board exactly once.

 * You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1]
 * where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.

 * Return true if grid represents a valid configuration of the knight's movements or false otherwise.

 * Note that a valid knight move consists of moving two squares vertically and one square horizontally,
 * or two squares horizontally and one square vertically. The figure below illustrates all the possible eight moves of a knight from some cell.
 */
public class NKnights {
    public boolean checkValidGrid(int[][] grid) {
        return backtrack(grid, 0,0, 0);
    }
    private boolean backtrack(int [][]grid, int i, int j, int visited){
        if(grid[0][0]!=0)return false;
        int n=grid.length;
        if(visited==n*n-1)return true;
        int []nextI={-1};
        int []nextJ={-1};
        containsNext(grid, i, j, nextI, nextJ);
        if(nextI[0]==-1)return false;
        return backtrack(grid, nextI[0], nextJ[0], visited+1);
    }
    private void containsNext(int [][]grid, int i, int j, int[] nextI, int[] nextJ){
        int n=grid.length;
        if((i-2)>=0 && (j-1)>=0 && grid[i-2][j-1]==grid[i][j]+1){
            nextI[0]=i-2;
            nextJ[0]=j-1;
            return;
        }
        if((i-1)>=0 && (j-2)>=0 && grid[i-1][j-2]==grid[i][j]+1){
            nextI[0]=i-1;
            nextJ[0]=j-2;
            return;
        }
        if((i+1)<n && (j-2)>=0 && grid[i+1][j-2]==grid[i][j]+1){
            nextI[0]=i+1;
            nextJ[0]=j-2;
            return;
        }
        if((i-2)>=0 && (j+1)<n && grid[i-2][j+1]==grid[i][j]+1){
            nextI[0]=i-2;
            nextJ[0]=j+1;
            return;
        }
        if((i+2)<n && (j-1)>=0 && grid[i+2][j-1]==grid[i][j]+1){
            nextI[0]=i+2;
            nextJ[0]=j-1;
            return;
        }
        if((i-1)>=0 && (j+2)<n && grid[i-1][j+2]==grid[i][j]+1){
            nextI[0]=i-1;
            nextJ[0]=j+2;
            return;
        }
        if((i+2)<n && (j+1)<n && grid[i+2][j+1]==grid[i][j]+1){
            nextI[0]=i+2;
            nextJ[0]=j+1;
            return;
        }
        if((i+1)<n && (j+2)<n && grid[i+1][j+2]==grid[i][j]+1){
            nextI[0]=i+1;
            nextJ[0]=j+2;
            return;
        }

    }

}
