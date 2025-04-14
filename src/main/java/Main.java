import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    String s="";
    public static void main(String[] args) {

        System.out.print("Hello and welcome!");

        System.out.println("Try programiz.pro");

        Function<Integer, Integer> f= i->i*i;
        Function<Integer, Integer> f1=i->i/2;
        System.out.println(f.andThen(f1).apply(20));

         List<Integer> l= Arrays.asList(10,1,4,5,8);
         List<Integer> l2= l.stream()
                 .filter(i-> i%2 == 0)
                 .map(i->i*i)
                 .toList();
         l2.forEach(i-> System.out.println(i));
        System.out.println(l2);




        ArrayList<String> sl=new ArrayList<>();
        sl.add("hello");
        sl.add("world");
        sl.add("");
        int x=10;

        Predicate<String> p= s1 -> {
            new Main().s="welcome"; // s value can be change
            System.out.println(x); // x value can't change once it initialized when we have predicate
            return !s1.isEmpty();
        };

//        System.out.println(p.test(sl.get(0)));

        List<String> x1 = sl.stream()
                .filter(p)
//               .map(i->i+"hh")
                .collect(Collectors.toList());

        for(String i : x1){
            System.out.println(i);
        }

        System.out.println(x1.size()); //2

        Main d=new Main();
        d.s = "hai";

    }
}