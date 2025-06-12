import java.util.*;
class BST{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int data){
        if(root==null){
            root = new Node(data);
            return root;
        }

        if(root.data>data){
            root.left = insert(root.left,data);
        }

        else{
            root.right = insert(root.right,data);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static Boolean search(Node root,int data){
        if(root.left==null && root.right==null && root.data!=data){
            return false;
        }
        else if(root.data==data){
            return true;
        }
        else if(root.data>data){
            return search(root.left,data);
        }
        else{
            return search(root.right,data);
        }
    }

    public static Node delete(Node root,int data){
        if(root.left==null && root.right==null && root.data!=data){
            return root;
        }
        else if(root.data>data){
            root.left = delete(root.left,data);
        }
        else if(root.data<data){
            root.right = delete(root.right,data);
        }
        else {//root.data==data
            //case 1
            if(root.left==null && root.right==null)
                return null;
            //case 2
            else if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            //case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);

        }

        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }

        return root;
    }

    public static void printInRange(Node root,int x,int y){
        if(root==null)
            return;
        else if(root.data>=x && root.data<=y){
            printInRange(root.left, x, y);
            System.out.print(root.data+" ");
            printInRange(root.right, x, y);
        }
        else if(root.data>=y)
            printInRange(root.left, x, y);
        else
            printInRange(root.right, x, y);
    }

    public static void main(String args[]){
        int[] l={5,1,3,4,2,7};
        Node root = null;
        for(int i=0;i<l.length;i++){
            root = insert(root,l[i]);
        }
        // inorder(root);
        // System.out.println();
        // System.out.println(search(root,8));
        // delete(root, 1);
        // inorder(root);
        // System.out.println();
        // delete(root, 0);
        // inorder(root);

        printInRange(root, 2, 5);
    }
}