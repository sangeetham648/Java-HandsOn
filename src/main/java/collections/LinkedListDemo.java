package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] a){
        LinkedList<String> myList = new LinkedList<String>();

        myList.add("Hello");
        myList.add("World");
        myList.add("hai");

        myList.set(1,"India");

        myList.add("welcome");

        System.out.println(myList.size()); //4

        myList.remove(3);

        System.out.println(myList.size()); //3

        System.out.println(myList.contains("India")); // true

        System.out.println(myList.get(2)); //hai

        Iterator<String> it = myList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
