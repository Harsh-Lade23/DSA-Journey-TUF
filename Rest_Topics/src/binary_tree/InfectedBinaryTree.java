package binary_tree;

public class InfectedBinaryTree {
    boolean isStartFound=false;
    int foundAt=0;
    int maxPath=0;
    public int amountOfTime(TreeNode root, int start) {
        depth(root, start, 1);
        return maxPath;
    }
    private int depth(TreeNode root, int start, int topDepth){
        if(root==null)return 0;
        if(root.left==null && root.right==null){
            System.out.println("leaf -  "+root.val);
            if(root.val==start){
                isStartFound=true;
                foundAt=topDepth;
            }
            return 1;
        }
        int leftDepth=depth(root.left, start, topDepth+1);
        boolean isLeftFound= isStartFound;
        int rightDepth= depth(root.right, start, topDepth+1);

        System.out.print("\nroot = "+root.val+", leftDepth = "+leftDepth+", rightDep ="+rightDepth);
        System.out.print("\nisLeftFound = "+isLeftFound);
        if(root.val==start){
            System.out.print("\ncurrent is start - ");
            isStartFound=true;
            foundAt=topDepth;
            maxPath=Math.max(leftDepth, rightDepth);
            System.out.print("maxPath = "+maxPath);

        }
        else{
            int dist=foundAt-topDepth;
            if(isStartFound){
                System.out.print("\nchild found  - ");
                if(isLeftFound)dist+=rightDepth;
                else dist+=leftDepth;
                System.out.print("\ndist = "+dist);
                maxPath=Math.max(maxPath, dist);
                System.out.print("\nmaxPath = "+maxPath+"\n\n");
            }
        }
        return Math.max(leftDepth, rightDepth)+1;
    }
}
