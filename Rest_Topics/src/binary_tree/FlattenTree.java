package binary_tree;


/**
 * Problem: Leetcode - 114. Flatten Binary Tree to Linked List
 * Given the root of a binary tree, flatten the tree into a "linked list":

 * The "linked list" should use the same TreeNode class where the right child pointer points to
 * the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */

public class FlattenTree{

    public void flatten(TreeNode root) {
        flat(root, null);
    }
    public void flat(TreeNode root, TreeNode next){
        if(root==null)return;
        if(root.left==null && root.right==null){
            root.right=next;
            return;
        }

        if(root.right!=null){
            flat(root.right, next);
            if(root.left!=null)flat(root.left, root.right);
        }
        else{
            flat(root.left, next);
        }
        if(root.left!=null){
            root.right=root.left;
            root.left=null;
        }

    }
}
