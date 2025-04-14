public class MultiThread implements Runnable{
    int total = 0;
    @Override
    public void run() {
        synchronized (this){
            System.out.println("inside child sync block");
            for (int i=0;i<50;i++){
                total += i;
                System.out.println(i);
            }
            this.notify();
        }
    }
}
