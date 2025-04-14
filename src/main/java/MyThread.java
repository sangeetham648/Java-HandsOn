public class MyThread extends Thread{

    public void run(){
        for (int i=0;i<10;i++){
            System.out.println(i + " from child thread1");
        }
    }
}

class MyThread2 implements Runnable{
    static Thread mt;
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i + " from child thread2");
            try{
                //mt.join();
                Thread.sleep(500);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
