package arrays.hard;

public class PascalTriangle {
    public int[][] pascalTriangle(int numRows){
        int [][]arr = new int[numRows][numRows];

        for(int i=0;i<numRows;i++){
            arr[i][0]=1;
            for(int j=1;j<=i;j++){
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            }
        }


        return arr;
    }
}
