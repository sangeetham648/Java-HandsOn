import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Java 9-17
public class Demo3 {
    public static void main(String[] arg){
        AutoCloseable c = () -> System.out.println("Object is closed");
        try(c){
            System.out.println("from try");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        /**
         * o/p
         from try
         Object is closed -> default this will print, we can override the method
         */
        System.out.println("-----------------");

        /**
         * asList,List.of,Map.of -> immutable can't add or remove element, once it is initialised if we do UnsupportedOperationException will throw
         * Map<Integer, String> map= Map.of(1,"aa",2,"bb",3,"cc"); List<Integer> l= List.of(1,2,3,4);
         */

        List<Integer> l= Arrays.asList(1,2,3,4);
//        l.add(6);
        l.set(1,10);
//        l.remove(3);
        System.out.println(l); //[1, 10, 3, 4]

        List<Integer> l1= new ArrayList<>(Arrays.asList(100,2,3,4,5)); // In arraylist we can do all operation
        l1.add(6);
        l1.set(1,10);
        l1.remove(3);
        System.out.println(l1); //[100, 10, 3, 5, 6]

        System.out.println("-----------------");

        // takeWhile
        System.out.println( // l1 = [100, 10, 3, 5, 6] from above
                l1.stream().takeWhile(x->x%5 == 0).collect(Collectors.toList())
        );
        //[100, 10] - takes the value until the condition is false

        //dropWhile
        System.out.println( // l1 = [100, 10, 3, 5, 6] from above
                l1.stream().dropWhile(x->x%5 == 0).collect(Collectors.toList())
        );
        //[3, 5, 6] - ignored the value which satisfied the condition until not satisfied first value

        // stream.ofNullable() method
        l1.add(null);
        System.out.println(l1); // [100, 10, 3, 5, 6, null]
        System.out.println(
                l1.stream().flatMap(Stream::ofNullable).collect(Collectors.toList())
//                l1.stream().flatMap(x-> Stream.ofNullable(x)).collect(Collectors.toList()) - ignoring the null value
        );

        System.out.println("-----------------");

        // variable - var, instead of primitive and none primitive data type we can use, but it should be initialised with value,
        // can't assign null, used within local(method) scope not in class level

        int x;
        x=10; // for primitive type is fine declaration and initialisation in different phase
        var i = 100; // var i; -> is not allowed

        var h = new HashMap<Integer,String >();
        h.put(1,"sasi");
        System.out.println("var hashmap 1 : "+h.get(1)); // sasi

        System.out.println("-----------------");

        String s= "";
        System.out.println(s.isBlank() + " "+ s.isEmpty()); // true true

        s=" ";
        System.out.println(s.isBlank()+ " "+ s.isEmpty()); // true false --> having space inside so not empty

        s=null;
        System.out.println(s); //null

        s="Hello\nWorld";
        System.out.println(s.lines().collect(Collectors.toList())); // [Hello, World]

        s="Hello world";
        System.out.println(s.repeat(5)); // repeating 5 times in same line - Hello worldHello worldHello worldHello worldHello world

        // convert string to char array
        char[] charArray = s.toCharArray();
        System.out.println(charArray); // Hello world

        // convert string into integer
        s="12345";
        int n=Integer.parseInt(s); // s.transform(Integer::parseInt) , again to convert into string s.transform(Integer::parseInt).toString()
        System.out.println(n+s); // 1234512345
        System.out.println(n+n); // 24690
        System.out.println(s+s); // 1234512345

        // convert string into int array
//        int[] arr = s.chars()  // creates an IntStream of character ASCII values from java 8
//                .map(ci -> ci - '0')  // convert ASCII to digit -> '1' - '0' = 49-48 = 1
//                .toArray();         // collect to int[]

        int[] arr = new int[s.length()];

        for (int j = 0; j < s.length(); j++) {
            arr[j] = Character.getNumericValue(s.charAt(j));
        }
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]

        System.out.println("-----------------");

        // Unique code
        System.out.println('\u2655'); //♕
        System.out.println('\u265A'); //♚

        System.out.println("-----------------");
        // String content block

        String str = """
                
                hello
                    world
                """;
        System.out.println(str);

        System.out.println("-----------------");
        // switch case - yield , lambda expression can use
        int i2 = 10;
        int d = switch (i2){
            case 1:
                yield 1;
            default:
                yield 0;
        };
        System.out.println(d);
        int i3=1;
        int d1 = switch (i3){
            case 1 -> 1;
            default -> 0;
        };
        System.out.println(d1);

        System.out.println("-----------------");
        // Object is the parent class of all the class

        Object o="hello world";
        if(o instanceof String T){
            // implicitly String T = (String) o; -> executed
            System.out.println(T.length()); // 11
        }

        System.out.println("-----------------");
        //Collect filtering , teeing

        List<Employee> employees = Arrays.asList(
                new Employee(1,"abi",202300.335),
                new Employee(2,"banu",140000),
                new Employee(3,"charu",100000.00)
        );

        System.out.println(
                employees.stream().filter(e->e.getSalary()>100000).collect(Collectors.toList())
        );

        System.out.println(
                employees.stream().collect(Collectors.filtering(e->e.getSalary()>100000, Collectors.toList()))
        );

        Map<String , Employee> result = employees.stream().collect(
                Collectors.teeing(
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        Collectors.minBy(Comparator.comparing(Employee::getSalary)),
                        (e1,e2) -> {
                            Map<String, Employee> map = new HashMap<>();
                            map.put("Max", e1.get());
                            map.put("Min",e2.get());
                            return map;
                        }
                )
        );

        System.out.println(result);

        System.out.println("-----------------");
        // POJO class, Record
        Student student1 = new Student(1,"arun",470.20);
        System.out.println(student1.toString());
        Student student2 = new Student(2,"arun",470.20);
        System.out.println(student2.toString());
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        _Student _student1 = new _Student(1,"arun",470.20);
        System.out.println(_student1.toString());
        _Student _student2 = new _Student(2,"arun",470.20);
        System.out.println(_student2.toString());
        System.out.println(_student1.hashCode());
        System.out.println(_student2.hashCode());
    }
}

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee { " +
                "id = " + id +
                ", name = " + name +
                ", salary = " + salary +
                " } ";
    }

}

// POJO -> Plain Old Java Object
class Student{
    private int id;
    private String name;
    private double mark;

    public Student(int id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(mark, student.mark) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, mark); // if these values are same in object they will get same hashcode
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}