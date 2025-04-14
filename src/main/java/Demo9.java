import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo9 {
    // demo7 have future
    public static void main(String[] arg) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.runAsync(
                ()->{
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("From child thread");
                }
        );
        System.out.println(future.get());
        System.out.println("From main thread");

        System.out.println("---------------");
        Executor executor = Executors.newFixedThreadPool(20);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(
                ()->{
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    return "Java";
                }
                , executor);

        System.out.println(future1.get());
        System.out.println("From string main thread");

        System.out.println("---------------");

        CompletableFuture<Double> weightInKg = CompletableFuture.supplyAsync(
                ()->{
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    return 65.5;
                }
                );
        CompletableFuture<Double> heightInCm = CompletableFuture.supplyAsync(
                ()->{
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    return 166.2;
                }
        );

        CompletableFuture<Double> BMI = weightInKg.thenCombine(heightInCm,(weight,height) -> weight / (height*height));

        System.out.println(BMI.get());

        System.out.println("------------------");

        Integer age = -1;

        CompletableFuture<String> ageHandle = CompletableFuture.supplyAsync(
                () -> {
                    if(age<0) throw new IllegalArgumentException("Age cannot be negative");
                    else if (age>18) return "Adult";
                    else return "Child";
                }
        ).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return "Exception occured";
        });
        System.out.println(ageHandle.get());

        System.out.println("------------------");

    }
}
