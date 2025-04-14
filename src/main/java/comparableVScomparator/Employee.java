package comparableVScomparator;

import java.util.Comparator;

public class Employee {

    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        Employee e1=new Employee("sasi",21,750000);
        Employee e2=new Employee("sangi",24,1400000);

        AgeComparator ac=new AgeComparator();
        System.out.println(ac.compare(e1,e2));

        SalaryComparator sc=new SalaryComparator();
        System.out.println(sc.compare(e1,e2));
    }
}

class AgeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.age - o2.age;
    }
}

class SalaryComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.salary - o2.salary);
    }
}
