package arrays.medium;

import java.util.HashSet;

/** Problem - Leetcode
 * 73. Set Matrix Zeroes

 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 *
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {

        HashSet<Integer> row=new HashSet<Integer>();
        HashSet<Integer> column=new HashSet<Integer>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(row.contains(i) || column.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }

    // Follow Up - solve the problem without using any extra space.

    //Ans -
}
