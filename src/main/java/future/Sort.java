package future;

import java.util.*;

public abstract class Sort {

    public static void main(String[] args) {
        op(100L,100L,(x,y) -> x / y);
    }

    public static Integer operation(Integer num,DemoInterface demoInterface){
        return demoInterface.getValue(num);
    }

    public static void show(Map<String,String> map){
        System.out.println(operation(100,(y) -> y * y));
    }

    public static void op(Long l1, Long l2, MyFunction<Long,Long> myFunction){
        System.out.println(myFunction.getValue(l1,l2));
    }
}