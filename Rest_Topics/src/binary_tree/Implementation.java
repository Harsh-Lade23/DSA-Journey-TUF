package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Implementation {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
        }
    }


    public static int max(Node root){
        if(root==null)return Integer.MAX_VALUE;
        int max=Math.max(max(root.left), max(root.right));
        return Math.max(max, root.val);
    }


    public static int height(Node root){
        if(root==null)return -1;
        int max=Math.max(height(root.right), height(root.left));
        return max+1;
    }


    public static void display(Node root){
        if(root==null)return;
        System.out.println();
        System.out.printf("%d -> ",root.val);
        if (root.left!=null){
            System.out.print(root.left.val+", ");
        }
        else{
            System.out.print("null, ");
        }
        if (root.right!=null){
            System.out.print(root.right.val);
        }
        else{
            System.out.print("null");
        }
        System.out.println();
        display(root.left);
        display(root.right);
    }

    public static void breadthFirstSearch(Queue<Node>qu){
        if(qu.isEmpty())return;
        Node current=qu.peek();
        if(current.left!=null)qu.add(current.left);
        if(current.right!=null)qu.add(current.right);
        System.out.print(current.val+" ");
        qu.poll();
        breadthFirstSearch(qu);

    }
    public static void main (String []args) {
        Node root=new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e=new Node(6);
        root.left=a;
        root.right=b;
        a.left=c;
        a.right=d;
        d.right=e;
        Queue<Node> qu= new LinkedList<>();
        qu.add(root);
        breadthFirstSearch(qu);
    }
}
