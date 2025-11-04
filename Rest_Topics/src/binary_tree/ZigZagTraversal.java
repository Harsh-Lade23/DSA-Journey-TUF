package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


/**
 * Problem: Leetcode - 03. Binary Tree Zigzag Level Order Traversal

 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between)
 *
 */
public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>>ans =new ArrayList<>();
        if(root==null)return ans;
        ArrayDeque<TreeNode> deq=new ArrayDeque<>();
        deq.add(root);
        helper(ans, deq, 1);
        return ans;
    }
    private void helper(List<List<Integer>> ans, ArrayDeque<TreeNode> deq, int lev){
        if(deq.isEmpty())return;
        int size=deq.size();
        List<Integer> mini=new ArrayList<>();
        for(int i=0;i<size;i++){
            if(lev%2==0){//even level
                TreeNode temp=deq.removeLast();
                if(temp.right!=null)deq.addFirst(temp.right);
                if(temp.left!=null)deq.addFirst(temp.left);
                if(temp!=null)mini.add(temp.val);
            }
            else {//odd level
                TreeNode temp=deq.removeFirst();
                if(temp.left!=null)deq.addLast(temp.left);
                if(temp.right!=null)deq.addLast(temp.right);
                if(temp!=null)mini.add(temp.val);
            }
        }
        ans.add(mini);
        helper(ans, deq, lev+1);
    }
}
