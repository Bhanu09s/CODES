import java.util.HashSet;
import java.util.Iterator;
class HashSET{
    public static void main(String args[]){
        //Creating
        HashSet<Integer> set = new HashSet<>();

        //insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //search - contains
        if(set.contains(1)){
            System.out.println("contains 1");
        }

        //delete
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("1 is removed");
        }

        //size of set
        System.out.println(set.size());

        //print all elements of set
        System.out.println(set);

        //iterator
        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}