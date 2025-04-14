import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Java 8

public class Demo {
    int m1(Integer i, Integer j){
        return i.compareTo(j);
    }
    static int m2(Integer i, Integer j){
        return i.compareTo(j);
    }
    public static void main(String[] arg){
        Demo d=new Demo();
//        Comparator<Integer> c= d::m1; // non-static method reference accessed with demo object
//        Comparator<Integer> c1= Demo::m2; // static method reference accessed with demo class name

        List<Integer> l= Arrays.asList(10,1,4,5,8);
//        l.sort(Demo::m2);
        Collections.sort(l,Demo::m2);
        System.out.println(l);

        List<Integer> l1= Arrays.asList(10,1,4,5,8);
        l1.sort(d::m1);
        System.out.println(l1);

//        l1.forEach(i-> System.out.println(i));
        l1.forEach(System.out::println); // lambda expression

//        Bounded method reference - only for particular variable

        String str1 = "Sangeetha";

//        Supplier<String> sup= () -> str1.toLowerCase();
        Supplier<String> sup= str1::toLowerCase;
        System.out.println(sup.get());

//        Predicate<String> pre = (i) -> str1.startsWith(i);
        Predicate<String> pre = str1::startsWith;
        System.out.println(pre.test("S"));

//        UnBounded method reference
//        Function<String, String> fun1 = s->s.toLowerCase();
        Function<String, String> fun1 = String::toLowerCase;
        System.out.println(fun1.apply("Sasi"));

//        BiFunction<String,String,String> fun2 = (s1, s2)->  s1.concat(s2);
        BiFunction<String,String,String> fun2 = String::concat;
        System.out.println(fun2.apply("Sangeetha","Sasi"));



        // Access one class constructor with interface abstract method using constructor reference and lambda expression

        I i= Sample::new;  // I i=() -> new Sample();
        i.get();
//      i.get("Sample");

        X x=new X(); // consumer object
        x.accept("abc");
        List<String> list=Arrays.asList("demo");
        list.forEach(x);

        // Terminal operation
        System.out.println(Arrays.asList(1,0,-12,22,3,3,-1).stream().filter(a->a>0).collect(Collectors.toList()));
        System.out.println(Stream.of(1,2,0,3).filter(a->a>0).toList());

//        StringBuilder w = Stream.of("add","book","to","the","store")
//                .collect(() -> new StringBuilder(),
//                        (sb,str) -> sb.append(str),
//                        (sb1,sb2) -> sb1.append(sb2)
//                );
        StringBuilder w = Stream.of("add","book","to","the","store")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
        );
        System.out.println(w);

        String w1 = Stream.of("add","book","to","the","store")
                .filter(si -> si.length()>3)
                .reduce("reduce",(si,ci)-> si + ci
                );
        System.out.println(w1);

        BinaryOperator<Integer> op=(a,b)-> a+b;

        Stream<Integer> empty = Stream.empty();
        Stream<Integer> one = Stream.of(6);
        Stream<Integer> multiple = Stream.of(3,4,5);

        empty.reduce(op).ifPresent(System.out::println);
        one.reduce(op).ifPresent(System.out::println);
        multiple.reduce(op).ifPresent(System.out::println);

        System.out.println(Stream.of(1,2,1,20,13).filter(ip->ip>10).reduce(op).get()); // only if we have value >10 then get the sum, otherwise will get exception for get(), so need to add ifPresent()

        //Functional programming
        int len = Stream.of("hello","welcome","goodmorning")
                .reduce(0,
                        (count1,strg) -> count1+ strg.length(),
                        (n1,n2) -> n1+n2
                );
        System.out.println(len);

        List<String> names = Arrays.asList("john","peter");
        Predicate<String> predicate1 = name -> name.startsWith("j");

        System.out.println(names.stream().anyMatch(predicate1));
        System.out.println(names.stream().allMatch(predicate1));
        System.out.println(names.stream().noneMatch(predicate1));

        Stream.of("aad324","adw","asee","bchwd")
                .peek( sn -> System.out.println("1before filer "+sn))
                .filter(sn->sn.length()>3)
                .peek(s-> System.out.println("2after peek "+s))
                .sorted()
                .peek(s-> System.out.println("---3after sort "+s))
                .limit(1) // one item in forEach will print
                .forEach(s-> System.out.println("4from forEach "+s));

        List<String> li1= Arrays.asList("Hari","Krishna");
        List<String> l2= Arrays.asList("Thiru","Hari","Kumaran");
        Stream.of(li1,l2)
                .flatMap(Collection::stream) // used to merge 2 list
                .distinct() //to avoid duplicates
                .forEach(System.out::println);
//        Stream.of(li1,l2)
//                .flatMap(li-> li.stream())
//                .forEach(st-> System.out.println(st));

        System.out.println(IntStream.of(2,10,35,245).average()); // min,max.sum o/p:OptionalDouble[73.0]

        IntSummaryStatistics ins = IntStream.of(2,10,35,245).summaryStatistics();
        System.out.println("Average : "+ins.getAverage());

        IntStream.range(1,10).forEach(System.out::print);

        //DoubleSummary also there - DoubleSummaryStatistics

        // 5+10 -> 15+15 ->30+20
        int sum = Stream.of(5,10,15,20).mapToInt(inte1->inte1).sum();
        System.out.println(sum);

        // 5+10 15+20 -> 15+35
        int sum1 = Stream.of(5,10,15,20).mapToInt(inte2->inte2).parallel().sum();
        System.out.println(sum1);

    }

    public static void constructorMethodReference(){
//        Function<Integer, List<String>> al = x -> new ArrayList<>(x);
        Function<Integer, List<String>> al = ArrayList::new;
    }
}

class X implements Consumer{
    @Override
    public void accept(Object o) {
        System.out.println("welcome to X class"+o); //welcome to X classConstructorMethodReference
    }
}

interface I{
     Sample get();
//   Sample get(String s);
}

class Sample{
    Sample(){
        System.out.println("Cons 1");
    }
    Sample(String s){
        System.out.println("Cons 2"+ s);
    }
}