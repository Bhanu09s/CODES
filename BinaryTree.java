import java.util.*;
public class BinaryTree{

    static int cnt=0;
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BT{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    public static void postorder(Node root){
        if(root==null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;

    }

    public static int sumNodes(Node root){
        if(root==null){
            return 0;
        }
        return sumNodes(root.left)+sumNodes(root.right)+root.data;
    }

    public static int heightTree(Node root){
        if(root==null){
            return 0;
        }
        int LST = heightTree(root.left);
        int RST = heightTree(root.right);
        return Math.max(LST,RST)+1;
    }

    // Time complexity = O(N^2)
    public static int diameterTree(Node root){
        if(root==null){
            return 0;
        }
        int d1 = diameterTree(root.left);
        int d2 = diameterTree(root.right);
        int d3 = heightTree(root.left)+heightTree(root.right)+1;

        return Math.max(d3,Math.max(d1,d2));

    }

    // Time complexity = O(N)
    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }

    public static int optimizedDiameterTree(Node root){
        if(root==null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = optimizedDiameterTree(root.left);
        TreeInfo right = optimizedDiameterTree(root.right);

        int myHt = Math.max(left.ht,right.ht)+1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht+right.ht+1;

        int mydiam = Math.max(Math.max(diam1,diam2),diam3);

        TreeInfo myinfo = new TreeInfo(myHt, mydiam);

        return myinfo;

    }

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,-1};
        BT tree = new BT();
        Node root = tree.buildTree(nodes);
        //System.out.println(root.data);

        // preorder(root);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // postorder(root);

        //levelorder(root);

        //System.out.println(countNodes(root));

        //System.out.println(sumNodes(root));

        //System.out.println(heightTree(root));

        System.out.println(optimizedDiameterTree(root).diam);
    }
}