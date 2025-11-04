package binary_tree;

public class PathSum_I {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        return findSum(root, targetSum, 0);
    }
    public boolean findSum(TreeNode root, int targetSum, int currentSum){
        if(root.left==null && root.right==null){
            return targetSum==(currentSum+root.val);
        }
        boolean left=false;
        if(root.left!=null)left=findSum(root.left, targetSum, currentSum+root.val);
        boolean right=false;
        if(root.right!=null) right=findSum(root.right, targetSum, currentSum+root.val);

        return  left || right;

    }
}
