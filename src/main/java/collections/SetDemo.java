package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars); //[Volvo, Mazda, Ford, BMW]

        // set and get is not available
        System.out.println(cars.size()); // 5
        System.out.println(cars.contains("BMW")); // true
        cars.remove("BMW");
        System.out.println(cars); //[Volvo, Mazda, Ford]

        for(String s:cars){
            System.out.println(s);
        }
//        Volvo
//        Mazda
//        Ford
        Iterator<String> it = cars.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
