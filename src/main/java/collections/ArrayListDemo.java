package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] s){
        ArrayList<String> myList = new ArrayList<String>(10);

        myList.add("Hello");
        myList.add("World");
        myList.add("hai");

        myList.set(1,"India");

        myList.add("welcome");

        System.out.println(myList.size()); //4

        myList.remove(3);

        System.out.println(myList.size()); //3

        System.out.println(myList.contains("India")); // true

        // System.out.println(myList.get(4)); // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 3

//        Generics
//        ArrayList x[]={1,2,3,4,5} - won't allow need to create objecgt

        ArrayList<Integer> n=new ArrayList<>();
//        n= new ArrayList<>(){1, 2, 3, 4, 5}; --> can't initialise value to arrayList

        n = new ArrayList<>(Arrays.asList(1,2,3,4,5)); //

        System.out.println(n);

        Iterator<Integer> it = n.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        int x=10, y=10;
        System.out.println(x==y); // true
        y=11;
        System.out.println(x==y); // false
        //System.out.println(x1.equals(y1));  --> don't have build in methods for primitive data types

//      Integer x=10, y=10; ---> should not do like this Interger is a class so need to create object
        Integer x1=10;
        Integer y1=10;

        System.out.println(x1==y1); // true
        System.out.println(x1.equals(y1)); //true

        x1=127;
        y1=127;
        System.out.println(x1==y1); //true
        System.out.println(x1.equals(y1)); //true

        x1=128;
        y1=128;
        System.out.println(x1==y1); //false --> comparing object
        System.out.println(x1.equals(y1)); //true --> comparing value

        x1=127;
        y1=10;
        System.out.println(x1==y1); //false --> comparing object
        System.out.println(x1.equals(y1)); //false --> comparing value

        String s1="hi";
        String s2="hi";
        System.out.println(s1==s2); // true
        System.out.println(s1.equals(s2)); //true

        s2="hii";
        System.out.println(s1==s2); // false
        System.out.println(s1.equals(s2)); //false

        s1=s2;
        System.out.println(s1==s2); // true
        System.out.println(s1.equals(s2)); //true

        s1="hai";
        System.out.println(s1==s2); // false
        System.out.println(s1.equals(s2)); //false

        System.out.println(s2); // hi
    }
}




