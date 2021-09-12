package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = list.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(collect);

        List<Employee> employees = Arrays.asList(
                new Employee("张三", 100.0, 10, Status.BUSY),
                new Employee("李四", 10.0, 12, Status.BUSY),
                new Employee("王五", 170.0, 14, Status.BUSY),
                new Employee("赵六", 110.0, 7, Status.VOCATION),
                new Employee("田七", 130.0, 20, Status.FREE)
        );

        Optional<Integer> reduce = employees.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}
