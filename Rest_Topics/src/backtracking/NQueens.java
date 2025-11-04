package backtracking;

import java.util.ArrayList;
import java.util.List;


/** Problem: Leetcode- 51. N-Queens

 The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.
 You may return the answer in any order.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 both indicate a queen and an empty space, respectively.


 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char [][] mighty=new char[n][n];//Represent the current condition of board
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)mighty[i][j]='.';//Initializing the board as empty
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++) {
            backtrack(n, 0, 0, i, ans, mighty);
        }
        return ans;
    }
    private void backtrack(
            int n,
            int selectedQueens,
            int ro,
            int cl,
            List<List<String>> ans,
            char[][] mighty
    ){

        if(ro==n){

            addResult(n, ans, mighty);
            return;
        }
        if (shouldBreak(n, ro, cl, mighty)) return;

        mighty[ro][cl]='Q';
        for(int l=0;l<n;l++) {
            backtrack(n, selectedQueens + 1, ro + 1, l, ans, mighty);
            if(selectedQueens+1==n)break;
        }
        mighty[ro][cl]='.';

    }

    private static boolean shouldBreak(int n, int ro, int cl, char[][] mighty) {
        for(int i = 0; i< ro; i++){
            if(mighty[i][cl]=='Q') return true;
            int ind1=(cl - ro)+i;
            int ind2=(cl + ro)-i;
            if(ind1>=0 && ind1< n){
                if(mighty[i][ind1]=='Q') return true;
            }
            if(ind2>=0 && ind2< n){
                if(mighty[i][ind2]=='Q') return true;
            }

        }
        return false;
    }

    private static void addResult(int n, List<List<String>> ans, char[][] mighty) {
        List<String> ls=new ArrayList<>();
        for(int i = 0; i< n; i++) {
            String cur="";
            for(int j = 0; j< n; j++){
                cur+= mighty[i][j];
            }
            ls.add(cur);
        }
        ans.add(ls);
    }
}
