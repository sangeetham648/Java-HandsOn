import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Demo8 {
    //fork - split a large task to smaller subtask
    //join - combining the results of the subtasks to produce the final result
    public static void main(String[] arg){
        int[] array = new int[100];
        for(int i=0;i<array.length;i++){
            array[i] = i + 1;
        }
        SumTask sumTask = new SumTask(array,0,array.length);
        ForkJoinPool pool = new ForkJoinPool();
        int sum = pool.invoke(sumTask);
        System.out.println(sum);
    }
}

class SumTask extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 20;
    private int[] array;
    private int start;
    private int end;

    public SumTask(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end-start <= THRESHOLD){
            return sum();
        }else {
            int mid = (start+end)/2;
            SumTask leftTask = new SumTask(array,start,mid);
            SumTask rightTask = new SumTask(array,mid,end);

            leftTask.fork();
            int rightResult = rightTask.compute();
            int leftResult = leftTask.compute();

            return leftResult + rightResult;
        }
    }

    private int sum(){
        int total = 0;
        for(int i = start; i < end; i++){
            total += array[i];
        }
        return total;
    }
}