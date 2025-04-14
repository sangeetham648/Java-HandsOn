package collections;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args){
        //Creating HashSet and adding elements
        Set<String> set=new LinkedHashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");

        Iterator<String> i=set.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        System.out.println(set.size()); // 5
        System.out.println(set.contains("Two")); // true
        set.remove("Four");
        System.out.println(set);
    }
}
