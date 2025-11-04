package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> left=new ArrayList<>();
        List<TreeNode> right=new ArrayList<>();
        preorder(root.left, left);
        postorder(root.right, right);
        System.out.print("left: ");
        for(int i=0;i<left.size();i++){
            if(left.get(i)==null) System.out.print("null, ");
            else System.out.print(left.get(i).val+", ");
        }
        System.out.print("\nright: ");
        for(int i=0;i<right.size();i++){
            if(right.get(i)==null) System.out.print("null, ");
            else System.out.print(right.get(i).val+", ");
        }
        if(left.size()!=right.size())return false;

        for(int i=0;i<left.size();i++){
            if(left.get(i)==null || right.get(i)==null){
                if(left.get(i)!=right.get(i))return false;
            }
            else if(left.get(i).val!=right.get(i).val)return false;
        }
        return true;
    }
    private void preorder(TreeNode root, List<TreeNode> left){
        if(root==null){
            left.add(root);
            return;
        }
        left.add(root);
        preorder(root.left, left);
        preorder(root.right,left);
    }
    private void postorder(TreeNode root, List<TreeNode> right){
        if(root==null){
            right.add(root);
            return;
        }
        right.add(root);
        postorder(root.right, right);
        postorder(root.left,right);
    }
}
