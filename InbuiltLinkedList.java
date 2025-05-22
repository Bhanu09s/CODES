import java.util.LinkedList;

class InbuiltLinkedList{
    public static void main(String args[]){
        LinkedList<String> list = new LinkedList<>();
        
        list.addFirst("a");
        list.addFirst("is");
        System.out.println(list);
        list.addFirst("This");
        list.addLast("Inbuilt Linked list");
        System.out.println(list);

        list.add("Written");
        System.out.println(list);

        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" -> ");
        }
        System.out.println("null");

        int i;
        for(i=0;i<list.size();i++){
            if(list.get(i)=="a"){
                break;
            }
        }
        System.out.println(i);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove();
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

    }
}