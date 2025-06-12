import java.util.*;

class HashMAP{
    public static void main(String args[]){

        //country(Key), Population(value)
        HashMap<String,Integer> map = new HashMap<>();

        //Insertion
        map.put("India",120);
        map.put("US",30);
        map.put("China",150);

        System.out.println(map);

        map.put("China",180);

        System.out.println(map);

        //Search
        if(map.containsKey("China")){
            System.out.println("Key present");
        }
        else{
            System.out.println("Not Present");
        }

        System.out.println(map.get("China"));
        System.out.println(map.get("Italy"));

        // Iteration in HashMap
        for(Map.Entry<String,Integer> e: map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        Set<String> keys = map.keySet();
        for(String key:keys){
            System.out.println(key+" "+map.get(key));
        }

        //remove a pair in hashmap
        map.remove("China");
        System.out.println(map);
    }
}