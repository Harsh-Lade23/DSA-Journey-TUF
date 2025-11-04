package binary_tree;


import java.util.ArrayList;
import java.util.List;

/*Problem: Leetcode -145. Binary Tree Postorder Traversal
    Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans){
        if(root==null)return;
        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.val);
    }
}
