public class StringDemo {
    public static void main(String[] args) {

        String txt = "Hello World";

        System.out.println(txt.toUpperCase());
        System.out.println(txt.toLowerCase());
        System.out.println("The length of the txt string is: " + txt.length());
        System.out.println(txt.indexOf("World"));

        String firstName = "John";
        String lastName = "Doe";

        System.out.println(firstName + " " + lastName);
        System.out.println(firstName.concat(lastName));

        int x = 10;
        int y = 20;
        int z = x + y;  // z will be 30 (an integer/number)

        String x1 = "10";
        String y1 = "20";
        String z1 = x1 + y1;  // z will be 1020 (a String)
        System.out.println(x1.compareTo(y1)); //-1 (ascii value of 10 - ascii value of 20)

        String x2 = "10";
        int y2 = 20;
        String z2 = x2 + y2;  // z will be 1020 (a String)

        String txt1 = "We are the so-called \"Vikings\" from the north, The character \\ is called backslash.";
        System.out.println(txt1); //We are the so-called "Vikings" from the north,The character \ is called backslash.

        double num = 10 / 3;
        System.out.println(num); // 3.0 -> In Java, when performing integer division, if both operands are integers, the result is also an integer

    }
}
