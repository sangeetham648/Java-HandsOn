package comparableVScomparator;

public class Test {
    public static void main(String[] args) {
        Student s1=new Student("Sasi",20,80);
        Student s2=new Student("Sangi",24,80);
        Student s3=new Student("Sasi",20,80);

        System.out.println(s1.compareTo(s2)); // returning the difference value of one argument
        // comparable is interface, overriding the compare to method based on our comparing value preference

        String str1="hello";
        String str2="hello";
        String str3 ="haii";
        System.out.println(str1.compareTo(str2)); // ascii value of str1 - ascii value of str2 = 0
        System.out.println(str1.compareTo(str3)); // 4

        System.out.println(s1.equals(s2)); // false
        System.out.println(s1.equals(s3)); // true -> comparing each parameter return boolean, if s1 and s3 having same value so will return true. but the will point to different locations

        System.out.println(s1+" "+ s2+" "+s3);
        /* before having hash code method in student s1 and s3 is having diff location
        comparableVScomparator.Student@378bf509 comparableVScomparator.Student@5fd0d5ae comparableVScomparator.Student@2d98a335
        After added hashCode() method, by default it is calling, s1 and s3 having same location
        comparableVScomparator.Student@68 comparableVScomparator.Student@6d comparableVScomparator.Student@68
        */
    }
}
