import java.util.concurrent.*;

public class Demo7 {
    // ScheduledExecutorService, ExecutorService
    public static void main(String[] arg) throws ExecutionException, InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("from child thread");
        }, 0,1000,TimeUnit.MILLISECONDS);

        Thread.sleep(2000);
        scheduledExecutorService.shutdown();

        System.out.println("-----------------");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(new DemoThread());
        System.out.println("Doing other work");
        System.out.println(future.get());
        /** Future
         * calling child thread and return value displayed , blocking the main thread ,
         * multiple can't be chained together, combine multiple futures together not possible, no exception handing happen
         * To overcome above issue java 8 has "completableFuture" class - refer Demo9 class
         **/
        executorService.shutdown();

        System.out.println("-----------------");

    }
}

class DemoThread implements Callable<Integer> {
    // Runnable is having run method and return is void, if we want to return value to main thread used callable

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 1;
    }
}