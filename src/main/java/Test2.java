public class Test2 {
    private String privateField = "Private Field from Test class";

    public Test2(String privateField){
        this.privateField = privateField;
    }

    public static void main(String[] args){
    }
    public static void add(Integer i){
        System.out.println("from add");
    }
}
