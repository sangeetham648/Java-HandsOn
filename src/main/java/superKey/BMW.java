package superKey;

public class BMW extends Car{
    int x;
    public  BMW(){
        // implicitly super() is called here, as default parent constructor
        System.out.println("BMW constructor");
    }
    public BMW(int x,int y){
        // implicitly super() is called here, as default parent constructor below parameterized is called so default won't call
        super(y);
        this.x = x;
        System.out.println("X : "+this.x);
    }
}
