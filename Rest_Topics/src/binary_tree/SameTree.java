package binary_tree;


/**
 * Problem: Leetcode - 100. Same Tree.
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.

 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.

 */
public class SameTree {
    /*  We can make a list and store the elements of both
        trees, and then we can compare both the list and return
        the answer.
        But, it will take space = O(m+n), time = O(2m+n).

        Can we optimize it?
        Yes, I think, If we can call the function recursively
        with both head,and yes we can... we will pass both root
        and their child until both of the loop finishes.
        Base Case: If any one of them reach to the end, then we
        can check if the other one has been ended of not, if
        no then return false, else return true;

        Self work: If both node has different value return false;
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p == null && q == null;
        }
        if(p.val!=q.val)return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
