package collections;

import java.util.*;

public class TreeMapComparator {
    public static void main(String[] args) {

        // tree will automatically sort the Map by key value, but here we want to do sort by value
        TreeMap<String, Integer> tm=new TreeMap<>();
        tm.put("john",30);
        tm.put("peter",20);
        tm.put("adam",25);

        System.out.println(tm); //{adam=25, john=30, peter=20}

        List<Map.Entry<String,Integer>> l=new ArrayList<>(tm.entrySet());

        System.out.println(l); //[adam=25, john=30, peter=20]

//        l.sort(new ValueComparator());

        l.sort(((o1, o2) -> o1.getValue().compareTo(o2.getValue()))); // lamba expression

        System.out.println(l); //[peter=20, adam=25, john=30]

    }
}

//class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
//
//    @Override
//    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//        return o1.getValue().compareTo(o2.getValue());
//    }
//}
