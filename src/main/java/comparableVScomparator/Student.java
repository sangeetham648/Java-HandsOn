package comparableVScomparator;

public class Student implements Comparable<Student>{

    String name;
    int age;
    int grade;

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student x) {
        return this.age - x.age;
    }

    // Object class has the equals, hashCode and toString method

    @Override
    public boolean equals(Object obj) {
        Student s2 = (Student) obj;
        boolean nameFlag = this.name.equals(s2.name); // string check
        boolean ageFlag = this.age - s2.age == 0; // int check
        boolean gradeFlag = this.grade - s2.grade == 0; // int check

        return nameFlag && ageFlag && gradeFlag;
    }

    @Override
    public int hashCode() {
        return this.name.length()+this.grade+this.age; // can add different logic here the thing is same values will have same location
    }

    @Override
    public String toString(){
        // default comparableVScomparator.Student@68
        return "Student name is "+this.name+". Age is "+this.age+". Grade is "+this.grade+".";
    }
}
