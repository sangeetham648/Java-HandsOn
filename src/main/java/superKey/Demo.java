package superKey;

public class Demo {
    public static void main(String[] a) {
        BMW bmw=new BMW();
        BMW bmw1=new BMW(10,20);

        String s="hello world";
        String[] S=s.split("l"); // ["he","","o wor","d"]
        String[] T=s.split(""); //["h","e","l","l","o"," ","w","o","r","l","d"]
        for (String i:S){
            System.out.println(i);
        }

    }
}
