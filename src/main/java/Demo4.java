import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;

public class Demo4 {
    //java 9-17
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        // Refections - java.lang.reflect.Method;

        Class<?> clas = Class.forName("java.util.ArrayList");
        for (Method method: clas.getMethods()){
            System.out.println(method.getName()); // all method for array list
        }

        System.out.println("-----------------");

        Test test = new Test();

        Field field = Test.class.getDeclaredField("privateField");
        field.setAccessible(true);
        field.set(test,"from reflection");
        System.out.println(field.get(test));

        Method method = Test.class.getMethod("add",Integer.class);
        method.invoke(test,10);

        Constructor<Test2> constructor = Test2.class.getConstructor(String.class);
        Test2 test2 = constructor.newInstance("hello world");
        System.out.println(test2);

        System.out.println("-----------------");
        //Annotations
        Method annotation = Demo4.class.getMethod("add");
        MySingleAnnotation mySingleAnnotation = annotation.getAnnotation(MySingleAnnotation.class);
        System.out.println(mySingleAnnotation.age());
        System.out.println(mySingleAnnotation.value());
        System.out.println(mySingleAnnotation.annotationType());
    }
    @MySingleAnnotation(value="example",age=24)
    public void add(){
        System.out.println("My single annotation");
    }
}
