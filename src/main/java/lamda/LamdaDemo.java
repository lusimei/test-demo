package lamda;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

public class LamdaDemo {

    public static void main(String[] args) {
        Predicate<Integer> pre = (e) -> e > 1;
        List<Employee> list = Arrays.asList(
                new Employee(12, "A",Status.FREE),
                new Employee(13, "B",Status.BUSY),
                new Employee(16, "C",Status.FREE),
                new Employee(15, "D",Status.BUSY),
                new Employee(17, "D",Status.FREE),
                new Employee(15, "D",Status.BUSY));

//        boolean b = list.stream().allMatch((e) -> e.getStatus().equals(Status.BUSY));
//        System.out.println(b);

//        boolean b = list.stream().anyMatch((e) -> e.getStatus().equals(Status.BUSY));
//        System.out.println(b);

//        boolean b = list.stream().noneMatch((e) -> e.getStatus().equals(Status.FREE));
//        System.out.println(b);

//        Optional<Employee> first = list.stream().sorted((e1, e2) -> -e1.getAge().compareTo(e2.getAge())).findFirst();
//        System.out.println(first.get());

//        Optional<Employee> first = list.stream().sorted((e1, e2) -> -e1.getAge().compareTo(e2.getAge())).findFirst();
//        System.out.println(first.orElse(new Employee()));

//        Optional<Employee> any = list.parallelStream().filter((e) -> e.getStatus().equals(Status.FREE)).findAny();
//        System.out.println(any.orElse(new Employee()));

//        long count = list.stream().count();
//        System.out.println(count);

//        Optional<Integer> max = list.stream().map(Employee::getAge).max((e1, e2) -> -e1.compareTo(e2));
//        System.out.println(max.get());

//        Optional<Employee> min = list.stream().max((e1, e2) -> e1.getAge().compareTo(e2.getAge()));
//        System.out.println(min.get());

        Optional<Integer> max = list.stream().map(Employee::getAge).min(Integer::compareTo);
        System.out.println(max.get());
    }
}
class Employee{

    private String name;
    private Integer age;
    private Status status;
    
    public Employee(){
        
    }

    public Employee(Integer age){
        this.age = age;
    }

    public Employee(Integer age,String name){
        this.age = age;
        this.name = name;
    }

    public Employee(Integer age,String name, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
enum Status{
    BUSY,FREE;
}