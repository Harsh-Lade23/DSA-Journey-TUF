package binary_tree;



/* Problem: Leetcode - 543. Diameter of Binary Tree
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



 */
public class DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int []ans=helper(root);
        return Math.max(ans[0],ans[1]);
    }
    // index, 0=max depth, 1=max diameter
    private int[] helper(TreeNode root){
        if(root.left==null && root.right==null){
            int[] a=new int[2];
            return a;
        }
        //left child
        int []leftD;
        if(root.left!=null){
            leftD=helper(root.left);
            leftD[0]+=1;
        }
        else leftD=new int[2];

        //right child
        int []rightD;
        if(root.right!=null){
            rightD=helper(root.right);
            rightD[0]+=1;
        }
        else rightD=new int[2];

        int inDia=leftD[0]+rightD[0];
        int maxDia=Math.max(leftD[1], Math.max(rightD[1],inDia));
        int []a={Math.max(leftD[0],rightD[0]),maxDia};
        return a;

    }
}
