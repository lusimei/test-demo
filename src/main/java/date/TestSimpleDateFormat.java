package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> callable = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20160605",dtf);
//                return DateFormatThreadLocal.convert("20160605");
            }
        };
        List<Future<LocalDate>> list = new ArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 20; i++) {
            Future<LocalDate> submit = service.submit(callable);
            list.add(submit);
        }

        for (Future<LocalDate> date : list){
            System.out.println(date.get());
        }
        service.shutdown();
    }
}
