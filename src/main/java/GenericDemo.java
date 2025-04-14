import java.util.ArrayList;

public class GenericDemo {
    public static void main(String[] args) {
        Gen<Integer> g1=new Gen<>(10);
        Gen<String> g2=new Gen<>("Sangeetha");

        GenMethod gm1=new GenMethod();
        gm1.add(10,12);

        GenMethod gm2=new GenMethod();
        gm1.add("hello","world");

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        // String list
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Cherry");

        System.out.println("Printing Integer List:");
        gm1.printList(intList);

        System.out.println("\nPrinting String List:");
        gm1.printList(stringList);
    }
}

class Gen<T>{ // <T extends Number>
    T i;
    public Gen(T x){
        i=x;
    }
}

class GenMethod{
    public <T> void add(T i, T j){ // T is considering as object
        System.out.println(i.equals(j));
    }

    // Method that accepts a list of any type using wildcard (?)
    public void printList(ArrayList<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

//    public <T> void add(ArrayList<?> l, T i){
//
//    }

}

// When we creating object that time we can add the type
// Generic class
// Generic with boundries ( extends parents)
// Generic methods
    // wild card character <?>