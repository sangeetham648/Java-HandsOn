import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private static AtomicInteger counter = new AtomicInteger(0);
    private static int counter1 =0;

    public static void main(String[] arg) throws InterruptedException {
        Thread thread1 = new Thread(
                ()->{
                    increment();
                }
        );
        Thread thread2 = new Thread(
                ()->{
                    increment();
                }
        );
        Thread thread3 = new Thread(
                ()->{
                    incrementInt();
                }
        );
        Thread thread4 = new Thread(
                ()->{
                    incrementInt();
                }
        );
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("Counter AutomicInt: "+counter);
        System.out.println("Counter int: "+counter1);

    }
    public static void increment(){
        for (int i=0; i<1000;i++){
            counter.getAndIncrement();
        }
    }

    public synchronized  static void incrementInt(){
        for (int i=0; i<1000;i++){
            counter1++;
        }
    }
}
