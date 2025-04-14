package exceptions;

import java.io.*;

public class ThrowsExample {
    public static void readFile() throws IOException {
        throw new IOException("File not found");
    }

    public static void checkAge(int age) throws ArithmeticException {
        if (age < 18) {
            throw new ArithmeticException("Age must be 18 or above");
        }
        System.out.println("Access granted");
    }

    public static void customCheck(boolean custom) throws CustomException {
        if (custom) {
            throw new CustomException("Custom exception checked");
        }
        System.out.println("Access granted");
    }

    public static void main(String[] args) throws CustomException {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Handled: " + e.getMessage());
        }

        try {
            checkAge(16);
        }catch (ArithmeticException e){
            System.out.println("Handled: "+e.getMessage());
        }

        try {
            customCheck(true);
        }catch (CustomException e){
            System.out.println("Handled: "+e.getMessage());
        }

        System.out.println("to be continued.....");

    }
}

//Handled: File not found
//Handled: Age must be 18 or above
//Handled: Custom exception checked
//to be continued.....
