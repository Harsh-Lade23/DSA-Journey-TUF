package binary_tree;


/**
 * Problem: Leetcode - 110. Balanced Binary Tree

 * Given a binary tree, determine if it is height-balanced.

 A height-balanced binary tree is a binary tree in which the depth of the two
 subtrees of every node never differs by more than one.
 */
public class BalancedBinaryTree {
    private int height=0;
    public boolean isBalanced(TreeNode root) {
        if(root==null ){
            height=-1;
            return true;
        }
        if(root.left==null && root.right==null){
            height=0;
            return true;
        }
        boolean isLeftBalanced=isBalanced(root.left);
        int leftH=height;
        boolean isRightBalanced=isBalanced(root.right);
        int rightH=height;
        int diff=Math.abs(leftH-rightH);
        height=Math.max(rightH, leftH)+1;
        if(diff<=1)return isLeftBalanced && isRightBalanced;
        else return false;
    }
}
