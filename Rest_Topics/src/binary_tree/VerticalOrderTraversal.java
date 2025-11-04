package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class VerticalOrderTraversal {
    int left=0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        int []size={1002, -1002,-1};//0-left, 1-right, //2-depth

        findDim(root, size, 0,1);
        int [][] elements=new int[size[2]][size[1]-size[0]+1];
        left=size[0];
        for(int i=0;i<elements.length;i++){
            for(int j=0;j<elements[i].length;j++){
                elements[i][j]=-1;
            }
        }
        System.out.println("left="+size[0]+", right = "+size[1]+", depth = "+size[2]);
        System.out.println("calling root = "+root.val+"row = "+(0)+"col = "+0);
        traverse(root, elements, 0,0);
        for(int i=0;i<elements.length;i++){
            List<Integer> mini=new ArrayList<>();
            for(int j=0;j<elements[i].length;j++){
                if(elements[i][j]!=-1)mini.add(elements[i][j]);
            }
            ans.add(mini);
        }
        return ans;
    }
    private void traverse(TreeNode root, int [][]elements, int row, int col){
        if(root==null)return;
        int toPut=root.val;
        int j=row-left;
        System.out.println("row = "+ col +", col = "+j+", val = "+root.val);
        while(elements[col][j]!=-1){
            toPut=elements[col][j];
            elements[col][j]=toPut;
            j++;
        }
        elements[col][j]=toPut;
        print2D_Array(elements);
        System.out.println();
        System.out.println();
        System.out.println();
        if(root.left!=null){
            System.out.println("calling root = "+root.left.val+", row = "+(row+1)+", col = "+col+1);
            traverse(root.left, elements, row-1,col+1);
        }
        System.out.println();
        System.out.println();
        if(root.right!=null){
            System.out.println("calling root = "+root.right.val+", row = "+(row+1)+", col = "+col+1);
            traverse(root.right, elements, row+1, col+1);
        }
    }


    private void findDim(TreeNode root, int[]size, int width, int depth){
        if(root==null)return;
        if(width<size[0])size[0]=width;
        if(width>size[1])size[1]=width;
        if(depth>=size[2])size[2]=depth;
        if(root.left!=null)findDim(root.left, size, width-1, depth+1);
        if(root.right!=null)findDim(root.right, size, width+1, depth+1);


    }

    static void print2D_Array(int[][] arr){
        System.out.println("Array: ");
        for (int i=0;i< arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
