package forkjoin;

import java.util.concurrent.ForkJoinTask;

public class ForkJoinCalculate extends ForkJoinTask<Long> {

    private Long start;
    private long end;

    private static final long THRESHOLD = 10000;

    public ForkJoinCalculate(Long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Long getRawResult() {
        Long length = end - start;

        if(length <= THRESHOLD){
            long sum = 0;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (start + end)/2;
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();

            return left.join() + right.join();
        }
    }

    @Override
    protected void setRawResult(Long value) {

    }

    @Override
    protected boolean exec() {
        return true;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
