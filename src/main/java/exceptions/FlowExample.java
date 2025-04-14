package exceptions;

public class FlowExample {
    public static void main(String[] args) {
        System.out.println("Start");

        try {
            int a = 10 / 0;  // Throws ArithmeticException
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught and handled");
        }
        finally {
            System.out.println("Finally always executes");
        }

        System.out.println("This will execute after catch");
    }
}
/* op
Start
Exception caught and handled
Finally always executes
This will execute after catch
*/

// if we don't have catch block
/*
* Start
* Finally always executes
* exception message will display
*/