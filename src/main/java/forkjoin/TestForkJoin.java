package forkjoin;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.LongStream;

public class TestForkJoin {

    public static void main(String[] args){
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0L, 100000000000L)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(reduce);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start,end).getSeconds());
    }
}
