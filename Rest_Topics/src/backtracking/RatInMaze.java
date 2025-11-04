package backtracking;

import recursion.CommonOperations;

import java.util.ArrayList;
import java.util.List;

/**Problem: Rat in a Maze
 * Consider a rat placed at position (0, 0) in an n x n square matrix mat[][].
 * The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

 * The matrix contains only two possible values:

 * 0: A blocked cell through which the rat cannot travel.
 * 1: A free cell that the rat can pass through.
 * Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1),
 * under the condition that the rat cannot revisit any cell along the same path. Furthermore,
 * the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
 * If no path exists, return an empty list.

 * Note: Return the final result vector in lexicographically the smallest order.
 *
 */
public class RatInMaze {

    public ArrayList<String > ratInMaze(int [][]arr){
        ArrayList<String> ans=new ArrayList<>();
        int m=arr.length;
        int n=arr[0].length;
        findPath(0,0,n-1, m-1, arr, ans, "");
        return ans;
    }
    private void findPath(int stcl, int stro, int endcl, int endro, int[][]arr, ArrayList<String> ans, String currentPath){

        if(stcl==endcl && stro==endro){
            ans.add(currentPath);
            return;
        }
        if(stcl>endcl || stro>endro || stcl<0 || stro<0) {
            return;
        }
        if (arr[stro][stcl]==0) {
            return;
        }
        //Close the box so no route will enter here again.
        arr[stro][stcl]=0;

        //Find Down
        findPath(stcl, stro+1, endcl, endro, arr, ans,currentPath+"D");

        //Find Left
        findPath(stcl-1,stro, endcl,endro,arr,ans,currentPath+"L");

        //Find Right
        findPath(stcl+1,stro, endcl,endro,arr,ans,currentPath+"R");

        //Find Up
        findPath(stcl,stro-1, endcl,endro,arr,ans,currentPath+"U");


        arr[stro][stcl]=1;//Open the box again


    }
}
















