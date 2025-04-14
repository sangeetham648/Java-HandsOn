package Java8Features;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class featuresDemo1 {
    public static void main(String[] args) {

        Calculator c1=new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };
        // Ananymous function

        System.out.println(c1.add(1,2));

        // 1. labda expression - reducing the line of code
            //  Calculators c = (x, y) -> {
            //      return x + y;
            //  };
            Calculators c = (x, y) -> x+y;

            System.out.println(c.add(10,20));

            c.sub();

            // 4. Stream API
        //➡ Process collections with operations like map, filter, reduce
        // list.stream().filter(x -> x > 10).collect(Collectors.toList());

        // 5.Method References
        //➡ Shorthand for lambda expressions
        //list.forEach(System.out::println);

        // 7.  forEach() Method
        //➡ Iterate over a collection
        // list.forEach(item -> System.out.println(item));

        // 8.  Predicate Interface
        //➡ Represents a boolean condition

        Predicate<Integer> isEven = x -> x % 2 == 0;

        //9. Consumer Interface
        //➡ Takes one input and returns nothing
        Consumer<String> print = x -> System.out.println(x);

        // 10.Supplier Interface
        //➡ Returns a result without input
        Supplier<Double> random = () -> Math.random();

        // 11.Function Interface
        //➡ Takes one input, returns one output
        Function<String, Integer> length = s -> s.length();

        // 12. Parallel Streams
        //➡ Process large data using multithreading
        //list.parallelStream().forEach(System.out::println);



    }
}

interface Calculator {
    int add(int a, int b);

    // normal interface will have one or more abstract method, all should override in child

    //6.  Interfaces can now have static methods
    static void print() {
        System.out.println("Static method");
    }
}

// 2. functional interface - only one abstract method Examples: Runnable, Callable, Comparator, Predicate
// 3. Default method - no need to override in child

@FunctionalInterface
interface Calculators{
    int add(int a, int b);

    default void sub(){
        System.out.println("from sub method");
    }
}

