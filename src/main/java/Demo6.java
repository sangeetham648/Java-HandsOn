/**
 * In Java, a thread is a lightweight subprocess — the smallest unit of execution. Java allows you to create and manage multiple threads,
 * enabling concurrent execution of two or more parts of a program for maximum utilization of CPU.
 *----
 *  Why Threads?
 * Threads are used to perform multiple tasks simultaneously, such as:
 * Downloading a file while playing a video
 * Handling multiple users in a server application
 * Background tasks like autosave
 * -----
 * Thread Lifecycle:
 * New – Thread is created.
 * Runnable – Thread is ready to run.
 * Running – Thread is executing.
 * Blocked/Waiting – Thread is waiting for a resource.
 * Terminated – Thread has completed execution.
 * -----
 * Method
 * start() - Starts the thread
 * run() -	Entry point for thread
 * sleep(ms) -	Puts thread to sleep for ms milliseconds
 * join() -	Waits for thread to die - make sure before created thread should complete
 * isAlive() -	Checks if thread is alive
 * setPriority() -	Sets thread priority
 * interrupt() - to interrupt thread when it is sleeping
 */
public class Demo6 {
    public static void main(String[] arg) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("demo"); // after 2000 miliseconds demo will print

        System.out.println("---------");

        MyThread myThread = new MyThread();
        myThread.start();
        for (int i=0; i<10;i++){
            System.out.println(i+" from thread1 main");
        }

        System.out.println("---------");

        MyThread2 myThread2 = new MyThread2();
        myThread2.mt = Thread.currentThread(); // to get current thread
        Thread thread = new Thread(myThread2);
        thread.start();
       // thread.setPriority(6); // -> setting priority to this
        // thread.join(); -> make sure all thread created before to complete
        //thread.join(); //  both main and child having join(), nothing is executing, program is on hold is called dead lock
        for (int i=0; i<10;i++){
            Thread.sleep(500);
            System.out.println(i+" from thread2 main");
        }

        System.out.println("---------");

        System.out.println(Thread.currentThread().getClass());
        Thread.currentThread().setName("custom thread"); // default it id main method thread changing the name to custom thread
//        System.out.println(1/0);

        System.out.println("---------");


    }
}
