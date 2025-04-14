public class VolatileDemo {

    public volatile int counter =0;
    // volatile is used to know one thread updated value to other thread even they simultaniouly running

    public static void main(String[] args){
        VolatileDemo data = new VolatileDemo();
        Thread thread = new Thread(
                ()->{
                    int oldVal = data.getCounter();
                    System.out.println("Thread "+Thread.currentThread().getId()+" Old value = "+oldVal);
                    data.increaseCounter();
                    int newVal = data.getCounter();
                    System.out.println("Thread "+Thread.currentThread().getId()+" Old value = "+newVal);
                }
        );
        Thread thread1 = new Thread(
                ()->{
                    int oldVal = data.getCounter();
                    System.out.println("Thread "+Thread.currentThread().getId()+" Old value = "+oldVal);
                    data.increaseCounter();
                    int newVal = data.getCounter();
                    System.out.println("Thread "+Thread.currentThread().getId()+" Old value = "+newVal);
                }
        );

        thread.start();
        thread1.start();
    }

    private void increaseCounter() {
        counter++;
    }

    private int getCounter() {
        return counter;
    }
}
