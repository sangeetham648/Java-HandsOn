public class Test {
    private final String privateField = "Private Field from Test class";

    public static void main(String[] args){
        System.out.println(new Test().privateField);
    }
    public static void add(Integer i){
        System.out.println("from add");
    }
}
