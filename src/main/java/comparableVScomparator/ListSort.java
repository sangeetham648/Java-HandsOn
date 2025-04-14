package comparableVScomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        Employee e1=new Employee("sasi",291,750000);
        Employee e2=new Employee("sangi",24,1400000);


        List<Employee> l=new ArrayList<>();
        l.add(e1);
        l.add(e2);

        for(Employee e: l){
            System.out.println(e.name);
        }

        Collections.sort(l, new AgeComparator());
        for(Employee e: l){
            System.out.println(e.name);
        }

    }
}
