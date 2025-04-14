public class MultiThreadDemo {
    public static void main(String[] arg) throws InterruptedException {
        MultiThread multiThread = new MultiThread();
        Thread thread = new Thread(multiThread);
        thread.start();
        //wait(), notify() used instead of join()
        System.out.println("Main started child");
        synchronized (thread){
            thread.wait(); // seconds also can add
        }
        System.out.println(multiThread.total);
    }
}
