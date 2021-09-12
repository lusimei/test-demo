package future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class newJava {

    public static void main(String[] args) {
        apply(10000L,(x) -> System.out.println("Hello"+x));
        String str = strHandler("   HELLO   ", x -> x.trim());
        System.out.println(str);
        List<String> list = Arrays.asList("HEllO","WORLD","JAVA","String");
        List<String> result = filterStr(list, (x) -> x.contains("O"));
        System.out.println(result);
        List<Long> numList = getNumList(10, () -> new Random().nextLong());
        System.out.println(numList);
    }

    public static void apply(Long num,Consumer<Long> consumer){
        consumer.accept(num);
    }

    public static List<Long> getNumList(int num,Supplier<Long> supplier){
        List<Long> list = new ArrayList<Long>(num);
        Long aLong = supplier.get();
        for (int i = 0; i < num; i++) {
            list.add(aLong);
        }
        return list;
    }

    public static String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }

    public static List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> strList = new ArrayList<>();

        for(String str : list){
            if(predicate.test(str)){
                strList.add(str);
            }
        }

        return strList;
    }
}
