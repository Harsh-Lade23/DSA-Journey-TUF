package binary_tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Leetcode - 94. Binary Tree Inorder Traversal

 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans){
        if(root==null)return;
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);

    }
}
