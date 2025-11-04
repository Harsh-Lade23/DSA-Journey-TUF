package binary_tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Leetcode - 102. Binary Tree Level Order Traversal
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class LevelOrderTraversal {

/*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        int height=findHeight(root);
        for(int i=0;i<height;i++){
            List<Integer> mini=new ArrayList<Integer>();
            nthLevel(root, i, mini);
            ans.add(mini);
        }
        return ans;
    }
    private void nthLevel(TreeNode root, int level, List<Integer> levelElement){
        if(root==null)return;
        if(level==0){
            levelElement.add(root.val);
            return;
        }
        nthLevel(root.left, level-1, levelElement);
        nthLevel(root.right, level-1, levelElement);


    }
    private int findHeight(TreeNode root){
        if(root.left==null && root.right==null)return 1;
        int left=0;
        int right=0;
        if(root.left!=null)left=findHeight(root.left);
        if(root.right!=null)right=findHeight(root.right);
        return Math.max(left, right)+1;
    }
*/

    //Using Queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        ArrayDeque<TreeNode> qu=new ArrayDeque<>();
        qu.addLast(root);
        helper(ans, qu);
        return ans;
    }
    public void helper(List<List<Integer>> ans, ArrayDeque<TreeNode> qu){
        if(qu.isEmpty())return;
        int size=qu.size();
        List<Integer> mini=new ArrayList<>();
        for(int i=1;i<=size;i++){
            mini.add(qu.getFirst().val);
            TreeNode first=qu.removeFirst();
            if(first.left!=null)qu.addLast(first.left);
            if(first.right!=null)qu.addLast(first.right);
        }
        ans.add(mini);
        helper(ans, qu);
    }
}
