import java.util.ArrayList;
import java.util.Collections;

class ArrayLists{
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
       // ArrayList<Integer> list = new ArrayList<Integer>(); This is also correct
       // ArrayList<String> s = new ArrayList<>();
       // ArrayList<Boolean> b = new ArrayList<>();

       // add elements
        list.add(0);
        list.add(1);
        list.add(3);

       // get elements
        int elem = list.get(2);
        System.out.println(elem);

        // add element in between
        list.add(2,2);
        System.out.println(list);

        // Set element
        list.set(0,5);
        System.out.println(list);

        // delete element
        list.remove(2);
        System.out.println(list);

        // size
        int size = list.size();
        System.out.println(size);

        // Loops 
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

        System.out.println();

        // Sorting
        Collections.sort(list);
        System.out.println(list);
    }
}