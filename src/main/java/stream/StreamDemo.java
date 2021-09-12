package stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
//        System.out.println(reduce);

        List<Employee> employees = Arrays.asList(
            new Employee("张三", 100.0, 10, Status.BUSY),
            new Employee("李四", 10.0, 12, Status.BUSY),
            new Employee("王五", 170.0, 14, Status.BUSY),
            new Employee("赵六", 110.0, 7, Status.VOCATION),
            new Employee("田七", 130.0, 20, Status.FREE)
        );

        String collect1 = employees.stream().map(Employee::getName).collect(Collectors.joining());
        String collect2 = employees.stream().map(Employee::getName).collect(Collectors.joining("\t"));
        String collect3 = employees.stream().map(Employee::getName).collect(Collectors.joining("\t","&","&"));

        DoubleSummaryStatistics collect4 = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect4);

        System.out.println(collect3);

        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 100));
        System.out.println(collect);

//        Map<Status, Map<String, List<Employee>>> collect = employees.stream().collect(
//                Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
//                    Integer age = e.getAge();
//                    if (age <= 8) {
//                        return "幼年";
//                    } else if (age <= 12) {
//                        return "少年";
//                    } else {
//                        return "青年";
//                    }
//                })));
//        System.out.println(collect);

//        Map<Status, List<Employee>> collect = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getStatus));
//        System.out.println(collect);

//        Optional<Double> reduce = employees.stream()
//                .map(Employee::getSalary).reduce(Double::sum);
//            System.out.println(reduce.get());
//        List<String> collect = employees.stream()
//                .map(Employee::getName)
//                .collect(Collectors.toList());
//        collect.forEach(System.out::println);
//
//        Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());
//        set.forEach(System.out::println);

//        HashSet<String> hashSet = employees.stream().map(Employee::getName)
//                .collect(Collectors.toCollection(HashSet::new));
//        List<String> collect = hashSet.stream().collect(Collectors.toList());
//        collect.forEach(System.out::println);

//        Long collect = employees.stream().collect(Collectors.counting());
//        System.out.println(collect);
//
//        Double salary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
//        System.out.println(salary);
//
//        Optional<Employee> collect1 = employees.stream().collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
//        System.out.println(collect1.get());
//
//        Optional<Double> collect2 = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compareTo));
//        System.out.println(collect2.get());
    }

}

class Employee{

    private String name;
    private Double salary;
    private Integer age;
    private Status status;

    public Employee(String name, Double salary, Integer age, Status status) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}

enum Status{
    FREE,BUSY,VOCATION;
}