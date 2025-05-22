import java.util.*;

// Search --> O(n)
// Insert --> O(1)

class LinkedList{

    Node head;
    private int size;

    LinkedList(){
        this.size=0;
    }

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // add --> first and last
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }

        currNode.next=newNode;
    }

    public void printList(){

        if(head==null){
            System.out.println("List is empty");
        }

        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }

    // delete first
    public void deleteFirst(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }

        size--;
        head = head.next;
    }

    // delete last
    public void deleteLast(){
        if(head==null){
            System.out.println("This list is empty");
            return;
        }

        size--;

        if(head.next==null){
            head=null;
            return;
        }


        Node curr = head;
        while(curr.next.next!=null){
            curr=curr.next;
        }

        curr.next=null;
    }

    public int getSize(){
        return size;
    }

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("Linked List");
        list.addFirst("This");
        list.addLast("O(1) insert");
        list.addLast("and");
        list.addLast("O(n) search");
        list.printList();
        System.out.println();
        list.deleteFirst();
        list.printList();
        System.out.println();
        list.deleteLast();
        list.printList();
        System.out.println();
        System.out.println(list.getSize());
    }
}